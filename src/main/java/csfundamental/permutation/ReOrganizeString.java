package csfundamental.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/reorganize-string/
 */
public class ReOrganizeString {

    public static void main(String[] ar) {
        String str = "aab";
        ReOrganizeString obj = new ReOrganizeString();
        System.out.println(obj.reorganizeString(str));
    }

    public String reorganizeString(String S) {
        int start = 0;
        int end = S.length()-1;
        List<String> list = new ArrayList<>();
        permuteString(S,start , end , list);
        System.out.println(list);
        if(list.isEmpty()){
            return "";
        }
        return list.get(0);
    }

    public void permuteString(String S , int start , int end , List<String> list){
        if(start==end && list.size()==0) {
            if(isAdjacent(S)) {
                list.add(S);
            }
            return;
        }
        for(int i = start;i<=end;i++){
            S = swap(S,start,i);
            permuteString(S,start+1,end,list);
            S = swap(S,start,i);
        }
    }

    public boolean isAdjacent(String S){
        char[] cArray = S.toCharArray();
        for(int x=0;x<cArray.length;x++){
            if(x < cArray.length -1 && cArray[x]==cArray[x+1]){
                return false;
            }
        }
        return true;
    }

    public String swap(String S , int start , int end ){
        char[] cArray = S.toCharArray();
        char c = cArray[start];
        cArray[start] = cArray[end];
        cArray[end] = c;
        return new String(cArray);
    }

}
