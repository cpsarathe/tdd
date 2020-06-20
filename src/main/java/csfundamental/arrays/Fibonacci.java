package csfundamental.arrays;

public class Fibonacci {
    public static void main(String[] ar){
        int a0 = 0 , a1 = 1;
        int num = 3;
        int sum = a0 + a1;
        System.out.print( sum );
        for(int i = 0 ; i<=num ; i++){
            sum = a0 + a1;
            a0 = a1;
            a1 = sum;
            System.out.print(" " + sum + " " );
        }
    }
}
