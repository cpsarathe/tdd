package csfundamental.arrays;

public class RotateArray {
    public static void main(String[] ar){
        int[][] matrix = new int[3][3];
        int x = 1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                matrix[i][j] = x;
                x++;
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println("");
        }

        //rotateWithNewArray(matrix);

        rotateInPlace(matrix);
    }

    public static void rotateWithNewArray(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        int x =0 , y= 0;
        for(int row=0;row<matrix.length;row++){
            y = 0;
            for(int col=matrix[row].length-1;col>=0;col--){
                newMatrix[x][y] = matrix[col][row];
                y++;
            }
            x++;
        }
        for(int i=0;i<newMatrix.length;i++){
            for(int j=0;j<newMatrix.length;j++){
                System.out.print(newMatrix[i][j] +" ");
            }
            System.out.println("");
        }
    }

    public static void rotateInPlace(int[][] matrix) {
        int N = matrix.length;
        int low = 0;
        int temp = 0;
            temp = matrix[0][0];
            int temp2 = matrix[0][2];
            int temp3 = matrix[2][2];
            int temp4 = matrix[2][0];

            matrix[0][0] = temp4;
            matrix[0][2] = temp;
            matrix[2][2] = temp2;
            matrix[2][0] = temp3;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println("");
        }
    }
    }
