package csfundamental.graphs;

public class IslandPerimeter {

    public static void main(String[] ar){
        IslandPerimeter object = new IslandPerimeter();
        int[][] grid = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0},
        };
        System.out.println(object.islandPerimeter(grid));

    }

    public int islandPerimeter(int[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        int perimeter = 0;
        int top=0,bottom=0,left=0,right=0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    if(i==0){
                        top = 0;
                    } else {
                        top = grid[i-1][j];
                    }

                    if(j==0){
                        left = 0;
                    } else {
                        left = grid[i][j-1];
                    }

                    if(i==grid.length-1){
                        bottom = 0;
                    } else {
                        bottom = grid[i+1][j];
                    }

                    if(j==grid[0].length-1){
                        right = 0;
                    } else {
                        right = grid[i][j+1];
                    }
                    perimeter = perimeter + 4 - (top+left+bottom+right);

                }
            }
        }
        return perimeter;
    }


}
