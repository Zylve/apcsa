import java.util.ArrayList;

public class MSList {
    private ArrayList<int[][]> list;
    private int size = 1;

    public MSList(ArrayList<int[][]> list) {
        this.list = list;
    }

    public void run() {
        // Remove invalid squares and get largest square
        for(int i = 0; i < list.size(); i++) {
            int[][] square = list.get(i);
            int size = MagicSquareUtil.isMagicSquare(square);

            if(size == 0) {
                list.remove(i);
            }

            if(size > this.size) {
                this.size = size;
            }
        }

        // Remove duplicates
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < i; j++) {
                if(list.get(i).length == list.get(j).length) {
                    list.remove(i);
                    i--;

                    break;
                }
            }
        }

        // Bubble sort
        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i).length > list.get(i + 1).length) {
                int[][] swap = list.get(i + 1);

                list.set(i + 1, list.get(i));
                list.set(i, swap);
            }
        }

        // Fill in missing squares sequentially
        for(int i = 0; i < size; i++) {
            if(list.get(i).length > (i + 1)) {
                int[][] newSquare = MagicSquareUtil.generateMagicSquare(i + 1);

                list.add(i, newSquare);
            }
        }
    }

    public void printList() {
        for(int[][] square : list) {
            for(int[] row : square) {
                System.out.print("{");

                for(int i : row) {
                    System.out.print(i + ", ");
                }

                System.out.println("\b\b}");
            }
            
            System.out.println(MagicSquareUtil.isMagicSquare(square));
        }
    }
}
