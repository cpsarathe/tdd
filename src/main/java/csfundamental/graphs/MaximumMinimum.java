package csfundamental.graphs;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/path-with-maximum-minimum-value/
 */
public class MaximumMinimum {

    public static void main(String[] ar) {
        int rows = 3;
        int cols = 3;

        int[][] array = {
                {5, 4, 5},
                {1, 2, 6},
                {7, 4, 6}
        };

//        int x = 1,y=1;
//        int startingPos = array[x][y];
//
//        //moveNorth , moveDown
//        System.out.println("North of " + startingPos + " is " + array[x][y-1]);
//
//        //moveSouth , moveUp
//        System.out.println("South of " + startingPos + " is " + array[x][y+1]);
//
//        //moveEast , moveLeft
//        System.out.println("East of " + startingPos + " is " + array[x+1][y]);
//
//        //moveWest , moveRight
//        System.out.println("West of " + startingPos + " is " + array[x-1][y]);


        int minimum = minElementInAPath(array);
        System.out.println(minimum);

    }

    /**
     * Reference - https://leetcode.com/problems/path-with-maximum-minimum-value/discuss/322974/Java
     *
     * @param array
     * @return
     */
    public static int minElementInAPath(int[][] array) {

        PriorityQueue<MatrixElement> priorityQueue = new PriorityQueue<>((o1, o2) -> {
               return o2.val - o1.val;
        });

        boolean[][] visited = new boolean[array.length][array[0].length];

        int row =0 , col =0;
        int endRow =array.length-1 , endCol = array[array.length-1].length-1;
        int minimum = array[row][col];
        MatrixElement  matrixElement = new MatrixElement(row,col,array[row][col]);
        priorityQueue.add(matrixElement);

        while(!priorityQueue.isEmpty()){
            MatrixElement current = priorityQueue.poll();
            int r = current.row;
            int c = current.col;
            int v = current.val;
            visited[r][c] = true;

            minimum = Math.min(v,minimum);

            if(r == endRow && c==endCol){
                return minimum;
            }

            //move up
            if(r>0 && !visited[r-1][c]){
                priorityQueue.add(new MatrixElement(r-1,c,array[r-1][c]));
            }
            //move down
            if(r<endRow && !visited[r+1][c]){
                priorityQueue.add(new MatrixElement(r+1,c,array[r+1][c]));
            }

            //move left
            if(c>0 && !visited[r][c-1]){
                priorityQueue.add(new MatrixElement(r,c-1,array[r][c-1]));
            }

            //move right
            if(c<endCol && !visited[r][c+1]){
                priorityQueue.add(new MatrixElement(r,c+1,array[r][c+1]));
            }
        }
        return -1;
    }

    public static void moveDirections(int[][] array , int row , int col ,  int minimum) {
        if(row>array.length-1 || row < 0 ){
            return;
        }
        if(col>array[0].length-1 || col < 0 ){
            return;
        }
        int startingPos = array[row][col];
        if(startingPos<minimum) {
            minimum = startingPos;
        }

        moveDirections(array,row,col-1,minimum); //north
        moveDirections(array,row,col+1,minimum); //south
        moveDirections(array,row-1,col,minimum); //east
        moveDirections(array,row+1,col,minimum); //west

    }

}

class MatrixElement {
    int row;
    int col;
    int val;

    MatrixElement(int row,int col, int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
