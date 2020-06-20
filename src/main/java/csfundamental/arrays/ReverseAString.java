package csfundamental.arrays;

public class ReverseAString {

    public static void main(String[] ar) {
        String input = "lubhanal";
        String output = reverse(input);
        System.out.println(output);
		char[] reversed = reverseInPlace(input); 
		System.out.println(new String(reversed));		
    }

    public static String reverse(String input) {
        char[] revChar = new char[input.length()];
        for (int x = input.length() - 1,i=0; x >= 0; x--,i++) {
            revChar[i] = input.charAt(x);
        }
        return new String(revChar);
    }
	
	
    public static char[] reverseInPlace(String input) {
        char[] chars = input.toCharArray();
        for (int i=0,x=chars.length-1; i<chars.length;i++,x--) {
				if(i==x || i>x) break;
                char end = chars[x];
				char start = chars[i];
				char temp = end;
				chars[i] = temp;
				chars[x] = start;
        }
        return chars;
    }
}
