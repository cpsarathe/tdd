package csfundamental.graphs;

public class NumberOfIslands {
    public static void main(String[] ar){
        NumberOfIslands object = new NumberOfIslands();
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'},
        };
        System.out.println(numIslands(grid));
    }

    /**
     * https://leetcode.com/problems/number-of-islands/submissions/
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        if(grid==null || grid.length == 0){
            return 0;
        }
        int numIsland = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1') {
                    numIsland+=dfs(grid,i,j);
                }
            }
        }
        return numIsland;
    }

    public static int dfs(char[][] grid , int row, int col){
        if(row<0 || row>grid.length-1 || col<0 || col>grid[0].length-1 || grid[row][col]=='0'){
            return 0;
        }
        grid[row][col] = '0';
        dfs(grid , row-1, col);
        dfs(grid , row+1, col);
        dfs(grid , row, col-1);
        dfs(grid , row, col+1);
        return 1;
    }
}

