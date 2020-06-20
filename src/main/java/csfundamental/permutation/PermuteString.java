package csfundamental.permutation;

import java.util.ArrayList;
import java.util.List;

public class PermuteString {
    public static void main(String[] ar) {
        String str = "ABCDEF";
        PermuteString obj = new PermuteString();
        List<String> results = obj.permute(str);
        System.out.println(results);
    }

    public List<String> permute(String str) {
        List<String> strings = new ArrayList<>();
        permute(str, 0, str.length() - 1, strings);
        return strings;
    }

    public void permute(String str, int start, int end, List<String> strings) {
        if (start == end) {
            strings.add(str);
            return;
        }
        for (int i = start; i <= end; i++) {
            str = swap(str, start, i);
            permute(str, start + 1, end, strings);
            str = swap(str, start, i);
        }

    }

    public String swap(String str, int start, int end) {
        char[] ch = str.toCharArray();
        char temp = ch[start];
        ch[start] = ch[end];
        ch[end] = temp;
        return new String(ch);
    }

}
