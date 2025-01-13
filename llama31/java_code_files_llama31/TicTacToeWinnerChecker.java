/*
 * Decompiled with CFR 0.152.
 */
public class TicTacToeWinnerChecker {
    public boolean isWinner(char[][] cArray, char c) {
        int n;
        int n2;
        int n3;
        int n4 = cArray.length;
        int n5 = n4 == 3 ? 3 : (n4 == 4 ? 4 : (n4 == 5 ? 5 : 0));
        for (n3 = 0; n3 < n4; ++n3) {
            n2 = 0;
            for (n = 0; n < n4; ++n) {
                if (cArray[n3][n] == c) {
                    if (++n2 != n5) continue;
                    return true;
                }
                n2 = 0;
            }
        }
        for (n3 = 0; n3 < n4; ++n3) {
            n2 = 0;
            for (n = 0; n < n4; ++n) {
                if (cArray[n][n3] == c) {
                    if (++n2 != n5) continue;
                    return true;
                }
                n2 = 0;
            }
        }
        n3 = 0;
        for (n2 = 0; n2 < n4; ++n2) {
            if (cArray[n2][n2] == c) {
                if (++n3 != n5) continue;
                return true;
            }
            n3 = 0;
        }
        n3 = 0;
        for (n2 = 0; n2 < n4; ++n2) {
            if (cArray[n2][n4 - n2 - 1] == c) {
                if (++n3 != n5) continue;
                return true;
            }
            n3 = 0;
        }
        return false;
    }

    public static void main(String[] stringArray) {
        TicTacToeWinnerChecker ticTacToeWinnerChecker = new TicTacToeWinnerChecker();
        char[][] cArrayArray = new char[][]{{'X', 'O', 'X'}, {'O', 'X', 'O'}, {'X', 'O', 'X'}};
        System.out.println(ticTacToeWinnerChecker.isWinner(cArrayArray, 'X'));
    }
}
