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
}
