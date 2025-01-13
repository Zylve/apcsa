public class MagicSquareUtil {
    private MagicSquareUtil() { }

    private static int nValue = 1;
    private static int magicConstant = 1;

    public static int isMagicSquare(int[][] square) {
        nValue = square.length;

        // Reject non-squares
        for(int[] row : square) {
            if(row.length != nValue) {
                return 0;
            }
        }

        magicConstant = (nValue * nValue * nValue + nValue) / 2;

        // Check rows
        for(int[] row : square) {
            if(sum(row) != magicConstant) {
                return 0;
            }
        }

        // Check columns
        for(int i = 0; i < nValue; i++) {
            int sum = 0;

            for(int j = 0; j < nValue; j++) {
                sum += square[j][i];
            }

            if(sum != magicConstant) {
                return 0;
            }
        }

        // Check diagonals
        int sum = 0;

        for(int i = 0; i < nValue; i++) {
            sum += square[i][i];
        }

        if(sum != magicConstant) {
            return 0;
        }

        sum = 0;

        for(int i = 0; i < nValue; i++) {
            sum += square[i][nValue - i - 1];
        }

        if(sum != magicConstant) {
            return 0;
        }

        return magicConstant;
    }

    private static int sum(int[] row) {
        int sum = 0;

        for(int i : row) {
            sum += i;
        }

        return sum;
    }

    public static int[][] generateMagicSquare(int size) {
        if(size % 2 == 0) {
            return populateSquare(size);
        } else {
            return generateOddMagicSquare(size);
        }
    }

    private static int[][] generateOddMagicSquare(int size) {
        int[][] square = populateSquare(size);

        int x = size / 2;
        int y = 0;

        for(int i = 1; i <= Math.pow(size, 2); i++) {
            square[y][x] = i;

            if(y == 0) {
                y = size - 1;
            } else {
                y--;
            }

            if(x == size - 1) {
                x = 0;
            } else {
                x++;
            }

            if(square[y][x] != 0) {
                if(y == size - 1) {
                    y = 1;
                } else {
                    y++;
                    y++;
                }

                if(x == 0) {
                    x = size - 1;
                } else {
                    x--;
                }
            }
        }


        return square;
    }

    private static int[][] generateEvenMagicSquare(int size) {
        return new int[0][0];
    }

    private static int[][] populateSquare(int size) {
        int[][] square = new int[size][size];

        for(int i = 0; i < square.length; i++) {
            for(int j = 0; j < square[i].length; j++) {
                square[i][j] = 0;
            }
        }

        return square;
    }
}
