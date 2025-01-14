public class MSDriver {
    public static void main(String[] args) {
        // int[][] square3 = {
        // {2, 7, 6},
        // {9, 5, 1},
        // {4, 3, 8}
        // };

        // int[][] square5 = {
        // {85, 120, 5, 40, 75},
        // {115, 25, 35, 70, 80},
        // {10, 30, 65, 100, 110},
        // {50, 60, 95, 105, 15},
        // {55, 90, 125, 10, 45}
        // };

        // int[][] square8 = {
        // {52, 61, 4, 13, 20, 29, 36, 45},
        // {14, 3, 62, 51, 46, 35, 30, 19},
        // {53, 60, 5, 12, 21, 28, 37, 44},
        // {11, 6, 59, 54, 43, 38, 27, 22},
        // {55, 58, 7, 10, 23, 26, 39, 42},
        // {9, 8, 57, 56, 41, 40, 25, 24},
        // {50, 63, 2, 15, 18, 31, 34, 47},
        // {16, 1, 64, 49, 48, 33, 32, 17}
        // };

        // System.out.println(MagicSquareUtil.isMagicSquare(square3));
        // System.out.println(MagicSquareUtil.isMagicSquare(square5));
        // System.out.println(MagicSquareUtil.isMagicSquare(square8));

        MSList listAssignment = new MSList();
        listAssignment.readList();
        listAssignment.run();
        listAssignment.printList();
        listAssignment.writeList();
    }
}
