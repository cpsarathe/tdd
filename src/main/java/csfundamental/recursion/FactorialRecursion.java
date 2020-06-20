package csfundamental.recursion;

import java.util.HashMap;

public class FactorialRecursion {
    static HashMap<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] ar) {
        FactorialRecursion f = new FactorialRecursion();
        System.out.println(f.factorial(10));
        System.out.println(cache.entrySet());

    }

    public int factorial(int n) {
        int fact = 1;
        if (cache.get(n) != null) {
            System.out.println("cache hit");
            return cache.get(n);
        }
        else if (n == 1) {
            return n;
        }
        else {
            fact = factorial(n - 1) * n ;
            cache.put(n, fact);
        }
        return fact;
    }

}
