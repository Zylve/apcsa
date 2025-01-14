public class MagicSquareUtil {
    private MagicSquareUtil() {
    }

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
        if(size % 2 == 1) {
            return generateOddMagicSquare(size);
        } else if(size % 4 == 0) {
            return generateDoublyEvenMagicSquare(size);
        } else {
            return generateSinglyEvenMagicSquare(size);
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

    // https://www.1728.org/magicsq2.htm - Third solution
    private static int[][] generateDoublyEvenMagicSquare(int size) {
        int[][] square = populateSquare(size);
        // int rectangleLength = size / 2;
        int rectangleWidth = size / 4;

        // The corner boxes in the square.
        // x1, y1, x2, y2, inclusive
        int[] tlBoxBounds = { 0, 0, rectangleWidth - 1, rectangleWidth - 1 };
        int[] trBoxBounds = { size - rectangleWidth, 0, size - 1, rectangleWidth - 1 };
        int[] blBoxBounds = { 0, size - rectangleWidth, rectangleWidth - 1, size - 1 };
        int[] brBoxBounds = { size - rectangleWidth, size - rectangleWidth, size - 1, size - 1 };

        int x = 0;
        int y = 0;

        // First pass wtf is this bounds checking - fifth bound is the middle of the box.
        for(int i = 1; i <= size * size; i++) {
            if((x >= tlBoxBounds[0] && x <= tlBoxBounds[2]) && (y >= tlBoxBounds[1] && y <= tlBoxBounds[3])
                || (x >= trBoxBounds[0] && x <= trBoxBounds[2]) && (y >= trBoxBounds[1] && y <= trBoxBounds[3])
                || (x >= blBoxBounds[0] && x <= blBoxBounds[2]) && (y >= blBoxBounds[1] && y <= blBoxBounds[3])
                || (x >= brBoxBounds[0] && x <= brBoxBounds[2]) && (y >= brBoxBounds[1] && y <= brBoxBounds[3])
                || (x >= rectangleWidth && x < size - rectangleWidth) && (y >= rectangleWidth && y < size - rectangleWidth)) {

                // Do nothing
            } else {
                square[y][x] = i;
            }

            if(x == size - 1) {
                x = 0;
                y++;
            } else {
                x++;
            }
        }

        x = 0;
        y = 0;

        // Second pass
        for(int i = size * size; i >= 1; i--) {
            if((x >= tlBoxBounds[0] && x <= tlBoxBounds[2]) && (y >= tlBoxBounds[1] && y <= tlBoxBounds[3])
                || (x >= trBoxBounds[0] && x <= trBoxBounds[2]) && (y >= trBoxBounds[1] && y <= trBoxBounds[3])
                || (x >= blBoxBounds[0] && x <= blBoxBounds[2]) && (y >= blBoxBounds[1] && y <= blBoxBounds[3])
                || (x >= brBoxBounds[0] && x <= brBoxBounds[2]) && (y >= brBoxBounds[1] && y <= brBoxBounds[3])
                || (x >= rectangleWidth && x < size - rectangleWidth) && (y >= rectangleWidth && y < size - rectangleWidth)) {

                square[y][x] = i;
            } else {
                // Do nothing
            }

            if(x == size - 1) {
                x = 0;
                y++;
            } else {
                x++;
            }
        }

        return square;
    }

    // /mnt/c/Users/vukta/Projects/APCSA/misc/magicsquares/MagicSquareUtil.java
    // https://www.1728.org/magicsq3.htm
    private static int[][] generateSinglyEvenMagicSquare(int size) {
        int[][] square = populateSquare(size);
        int halfSize = size / 2;
        int rightColumnWidth = (int)((size / 4.0) - 1.5);
        int leftColumnWidth = halfSize / 2;
        int shiftRow = (halfSize / 2);

        int[][] subSquare = generateOddMagicSquare(halfSize);

        for(int i = 0; i < halfSize; i++) {
            for(int j = 0; j < halfSize; j++) {
                square[i][j] = subSquare[i][j];
                square[i + halfSize][j + halfSize] = subSquare[i][j] + (halfSize * halfSize);
                square[i][j + halfSize] = subSquare[i][j] + (2 * halfSize * halfSize);
                square[i + halfSize][j] = subSquare[i][j] + (3 * halfSize * halfSize);
            }
        }

        // Shift right columns
        for(int i = 0; i < halfSize; i++) {
            for(int j = 0; j < rightColumnWidth; j++) {
                int temp = square[i][size - j - 1];

                square[i][size - j - 1] = square[halfSize + i][size - j - 1];
                square[halfSize + i][size - j - 1] = temp;
            }
        }

        // Shift left columns

        for(int i = 0; i < halfSize; i++) {
            for(int j = 0; j < leftColumnWidth; j++) {

                if(i == shiftRow) {
                    int temp = square[i][j + 1];

                    square[i][j + 1] = square[halfSize + i][j + 1];
                    square[halfSize + i][j + 1] = temp;

                } else {
                    int temp = square[i][j];

                    square[i][j] = square[halfSize + i][j];
                    square[halfSize + i][j] = temp;
                }
            }
        }

        return square;
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
