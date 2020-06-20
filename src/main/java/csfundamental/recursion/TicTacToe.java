package csfundamental.recursion;

//Some test Case failing.
public class TicTacToe {
    public static void main(String[] ar) {
        TicTacToe ticTacToe = new TicTacToe();
        int[][] moves = {
                {0, 0}, {1, 1}, {2, 0}, {1, 0}, {1, 2}, {2, 1}, {0, 1}, {0, 2}, {2, 2}
        };
        System.out.println(ticTacToe.tictactoe(moves));
    }

    public String tictactoe(int[][] moves) {
        char[][] grid = new char[3][3];
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[0].length - 1; j++) {
                grid[i][j] = '@';
            }
        }
        char playerA = 'A';
        char playerB = 'B';
        for (int i = 0; i < moves.length; i++) {
            int[] move = moves[i];
            int x = move[0];
            int y = move[1];
            if ((x + 1) % 2 == 0) {
                grid[x][y] = playerB;
            } else {
                grid[x][y] = playerA;
            }
            String status = gameStatus(grid, x, y);

            if (status.contains("A") || status.contains("B")) {
                return status;
            } else {
                System.out.println(status);
            }
        }
        return "Draw";
    }

    public String gameStatus(char[][] grid, int row, int col) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        char currentVal = grid[row][col];
        if (row > rowLength - 1 && col > colLength - 1) {
            return "Pending";
        }
        if (grid[row][col] == ' ') {
            return "Pending";
        }

        if (grid[row][col] == ' ') {
            return "Pending";
        }
        boolean isRowValSame = false, isColValSame = false, isDiagonalSame = false;

        for (int i = row; i < row + 1; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == currentVal) {
                    isRowValSame = true;
                } else {
                    isRowValSame = false;
                }
            }
        }

        if (isRowValSame) return "" + currentVal;

        for (int i = 0; i < rowLength - 1; i++) {
            for (int j = colLength - 1; j < colLength; j++) {
                if (grid[i][j] == currentVal) {
                    isColValSame = true;
                } else {
                    isColValSame = false;
                }
            }
        }

        if (isColValSame) return "" + currentVal;

        if (row == 0 || row == rowLength - 1 || col == 0 || col == colLength - 1) {
            for (int i = 0; i < rowLength - 1; i++) {
                if (grid[i][i] == currentVal) {
                    isDiagonalSame = true;
                } else {
                    isDiagonalSame = false;
                }
            }

            for (int i = rowLength - 1; i >= 0; i--) {
                if (grid[i][i] == currentVal) {
                    isDiagonalSame = true;
                } else {
                    isDiagonalSame = false;
                }
            }
        }

        if (isDiagonalSame) return "" + currentVal;


        return "Pending";
    }


}