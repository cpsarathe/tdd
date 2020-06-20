package csfundamental.recursion;

public class FibonaciRecursion {

    public static void main(String[] ar){
        FibonaciRecursion f = new FibonaciRecursion();
        System.out.println(f.fibo(3));
    }

    public int fibo(int n){
        if(n<2) {
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }

}
