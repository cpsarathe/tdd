package csfundamental.graphs;

public class Maze {

    public static void main(String[] ar) {
        Maze maze = new Maze();
//        int[][] mazeGrid = {
//                {0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0},
//                {0, 0, 0, 1, 0},
//                {1, 1, 0, 1, 1},
//                {0, 0, 0, 0, 0}
//        };


        int[][] mG = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        int[] start = {0,4};
        int[] destination = {3,2};

        maze.hasPath(mG,start,destination);
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] visited = new int[maze.length][maze[0].length];
        boolean hasP = false;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (i == start[0] && j == start[1]) {
                    hasP = moveDFS(maze, i , j , destination, visited);
                    break;
                }
            }
        }
        System.out.println(maze[destination[0]][destination[1]]==1);
        return hasP;
    }

    public boolean isValidPath(int[][] maze, int rows, int cols , int[][] visited) {
        if (rows > maze.length - 1 || cols > maze[0].length - 1 || rows < 0 || cols < 0 || visited[rows][cols]==1) {
            return false;
        }
        return true;
    }

    public boolean moveDFS(int[][] maze, int row , int col, int[] destination, int[][] visited) {
        if (row == destination[0] && col == destination[1]) {
            maze[row][col] = 1;
            return true;
        }
        if(isValidPath(maze, row , col, visited) && maze[row][col]==0) {
            visited[row][col] = 1;
            moveDFS(maze, row - 1, col, destination,visited);
            moveDFS(maze, row + 1, col, destination,visited);
            moveDFS(maze, row, col - 1, destination,visited);
            moveDFS(maze, row, col + 1, destination,visited);
        }
        return false;
    }

}
