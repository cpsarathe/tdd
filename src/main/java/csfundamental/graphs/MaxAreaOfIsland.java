package csfundamental.graphs;

public class MaxAreaOfIsland {
    public static void main(String[] ar){
        MaxAreaOfIsland object = new MaxAreaOfIsland();
        char[][] grid = {
                {1,1,1,1,0},
                {1,1,0,1,0},
                {1,1,0,0,0},
                {0,0,0,0,0},
        };
        System.out.println(maxAreaOfIsland(grid));
    }

    /**
     * https://leetcode.com/problems/max-area-of-island/submissions/
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland(char[][] grid) {
        if(grid==null || grid.length == 0){
            return 0;
        }
        int maxArea = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1) {
                    maxArea = Math.max(maxArea,dfs(grid,i,j));
                }
            }
        }
        return maxArea;
    }

    public static int dfs(char[][] grid , int row, int col){
        if(row<0 || row>grid.length-1 || col<0 || col>grid[0].length-1 || grid[row][col]==0){
            return 0;
        }
        int val = grid[row][col]--;
        int up = dfs(grid , row-1, col);
        int down =  dfs(grid , row+1, col);
        int left =  dfs(grid , row, col-1);
        int right =  dfs(grid , row, col+1);
        return (val + up + down + left + right);
    }

}
