package csfundamental.arrays;

public class Factorial {
    public static void main(String[] ar) {
        Factorial f = new Factorial();
        System.out.println(f.factorial(5));
        long biilion = 10000000;
        long ff = 1;
        int counter = 0;
        while(ff < biilion){
            counter++;
            double d = ff * 1.5d;
            ff = Math.round(d);
        }
        System.out.println(ff);
        System.out.println(counter);
    }

    public int factorial(int n) {
        int fact = 1;
        if (n == 1) {
            return n;
        } else {
            for(int x = 1 ; x <= n ; x++){
                fact = fact * x;
            }
        }
        return fact;
    }

}
