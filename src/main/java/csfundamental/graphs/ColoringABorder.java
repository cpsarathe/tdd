package csfundamental.graphs;

public class ColoringABorder {

    public static void main(String[] ar) {
        ColoringABorder coloringABorder = new ColoringABorder();
        int[][] grid = {
                {1, 1,1},
                {1, 2,1}
        };
        int[][] copyGrid = coloringABorder.colorBorder(grid, 0, 0, 3);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }

//        for (int i = 0; i < copyGrid.length; i++) {
//            for (int j = 0; j < copyGrid[0].length; j++) {
//                System.out.print(copyGrid[i][j]);
//            }
//            System.out.println();
//        }
    }

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if (grid == null || grid.length == 0) {
            return grid;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] copyGrid = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                copyGrid[i][j] = grid[i][j];
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                colorConnected(grid,copyGrid, i, j, color,visited);
            }
        }
        if (r0 > 0 && r0 < grid.length - 1 && c0 > 0 && c0 < grid[0].length - 1) {
            copyGrid[r0][c0] = grid[r0][c0];
        }

        return copyGrid;
    }
/*
    public void colorConnected(int[][] grid, int row, int col, int color) {
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1 || grid[row][col] == '0') {
            return;
        }
        if(grid[row][col]==color){
            return;
        }
        grid[row][col] = color;
        colorConnected(grid, row - 1, col, color);
        colorConnected(grid, row + 1, col, color);
        colorConnected(grid, row, col - 1, color);
        colorConnected(grid, row, col + 1, color);
    }*/

    public void colorConnected(int[][] grid,int[][] copyGrid , int row, int col, int color,boolean[][] visited) {
        boolean isConnected = false;
        if(visited[row][col]){
            return;
        }

        if (row > 0 && grid[row - 1][col] == grid[row][col]) {
            copyGrid[row - 1][col] = color;
            isConnected = true;
        }
        if (row < grid.length - 1 && grid[row + 1][col] == grid[row][col]) {
            copyGrid[row + 1][col] = color;
            isConnected = true;
        }
        if (col > 0 && grid[row][col - 1] == grid[row][col]) {
            copyGrid[row][col - 1] = color;
            isConnected = true;
        }
        if (col < grid[0].length - 1 && grid[row][col + 1] == grid[row][col]) {
            copyGrid[row][col + 1] = color;
            isConnected = true;
        }

        if(isConnected){
            copyGrid[row][col] = color;
        }

        visited[row][col] = true;
    }
}
