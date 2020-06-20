package csfundamental.arrays;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] ar) {
        String s = "abcabd";
        String t = "abbdaf";
        boolean isValid = isValidAnagramUsingHashMap(s, t);
        System.out.println(isValid);
    }

    public static boolean isValidAnagramUsingHashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int x = 0; x < s.length(); x++) {
            if (map1.get(s.charAt(x)) == null) {
                map1.put(s.charAt(x), 1);
            } else {
                Integer val = map1.get(s.charAt(x));
                map1.put(s.charAt(x), val + 1);
            }

            if (map2.get(t.charAt(x)) == null) {
                map2.put(t.charAt(x), 1);
            } else {
                Integer val = map2.get(t.charAt(x));
                map2.put(t.charAt(x), val + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Character c = entry.getKey();
            Integer val1 = entry.getValue();
            Integer val2 = map2.get(c);
            if (!val1.equals(val2)) {
                return false;
            }
        }
        return true;
    }
}
