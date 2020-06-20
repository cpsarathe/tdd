package csfundamental.arrays;

public class ReplaceInString {

    public static void main(String[] ar) {
        String s = "abab d";
        //replace space in String with % , In place replacement
        char[] chars = s.toCharArray();
        for(int x = 0 ; x<chars.length ; x++){
            if(chars[x]==' '){
                chars[x] = '%';
            }
        }
        System.out.println(new String(chars));

        //replace space in String with %20C
        int spaceCount = 0;
        for(int x = 0 ; x<s.length() ; x++){
            if(s.charAt(x)==' '){
                spaceCount++;
            }
        }

        //replace space with %20C  using extra space in memory
        char[] chars2 = new char[s.toCharArray().length+(spaceCount*3)];
        int index = 0;
        for(int x = 0 ; x<s.toCharArray().length ; x++){
            if(s.charAt(x)==' '){
                chars2[index++] = '%';
                chars2[index++] = '2';
                chars2[index++] = '0';
                chars2[index++] = 'C';
            } else {
                chars2[index] = s.charAt(x);
                index++;
            }
        }
        System.out.println(new String(chars2));

    }
}
