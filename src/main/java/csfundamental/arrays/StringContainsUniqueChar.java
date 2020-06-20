package csfundamental.arrays;

import java.util.*;

public class StringContainsUniqueChar {

    public static void main(String[] ar) {
        String input = "FacebokIndia";
        //boolean isDuplicate = isDuplicateCharUsingHashMap(input);
        boolean isDuplicate = isDuplicateCharUsingArray(input);
        if (isDuplicate) {
            System.out.println("Duplicate character found");
        } else {
            System.out.println("No duplicate character found");
        }
    }

    public static boolean isDuplicateCharUsingHashMap(String input) {
        char[] chars = input.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == null) {
                map.put(chars[i], 1);
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean isDuplicateCharUsingArray(String input) {
        char[] chars = input.toCharArray();
        boolean[] bools = new boolean[256]; //assume ASCII table 256 characters
        for (int i = 0; i < chars.length; i++) {
            int x = chars[i];
            if(bools[x]){
                return true;
            } else {
                bools[x] = true;
            }
        }
        return false;
    }
}
