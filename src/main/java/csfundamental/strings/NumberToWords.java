package csfundamental.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/integer-to-english-words/
 *
 * This program needs more tuning to handle different cases and build in more reusable way
 */
public class NumberToWords {

    public static void main(String[] ar) {
        int num = 4;
        NumberToWords obj = new NumberToWords();
        System.out.println(obj.numberToWords(num));
    }

    public String numberToWords(int num) {
        Map<Integer,String> nDigMap = new HashMap<>();
        String[] singleDigWord =  {"One","Two","Three","Four","Five","Six" , "Seven" ,"Eight" ,"Nine"};
        String[] TwoDigWord =  {"Ten","Twenty","Thirty","Fourty" ,"Fifty" ,"Sixty" ,"Seventy","Eighty","Ninty"};
        nDigMap.put(100,"Hundred");
        nDigMap.put(1000,"Thousand");
        nDigMap.put(10000,"Ten Thousand");
        nDigMap.put(100000,"Hundred Thousand");
        nDigMap.put(1000000,"Million");

        int cNum = num;
        int digits = 0;
        while(cNum!=0) {
            cNum  = cNum/10;
            digits++;
        }

        int nNum = num;
        int div = 1;
        for(int x=0;x < digits-1;x++){
            div = div * 10;
        }
        List<String> list = new ArrayList<String>();

        while(nNum!=0) {
            int a = nNum / div;
            nNum = nNum%div;
            if(div > 99) {
                list.add(" " + singleDigWord[a-1] + " " + nDigMap.get(div));
            } else if(div < 99 && div > 9) {
                list.add(" " + TwoDigWord[a-1]);
            } else {
                list.add(" " +singleDigWord[a-1]);
            }
            div = div / 10;
        }

        String output = "";
        for(String s : list) {
            output = output + s;
        }

        return output;

    }

}
