package csfundamental.arrays;

public class RemoveDuplicateCharcatersInAString {
    public static void main(String[] ar) {
        String input = "abcabd";
        char[] newChars = removeDuplicateCharsWithoutExtraSpace(input.toCharArray());
        //works only for basic test case 1 occurence of duplicate char
        System.out.println(new String(newChars));

        char[] newChars2 = removeDuplicateCharsWithExtraSpace(input.toCharArray());
        System.out.println(new String(newChars2));

    }

    public static char[] removeDuplicateCharsWithExtraSpace(char[] input){
        if (input.length < 2) {
            return input;
        }
        boolean[] bools = new boolean[input.length]; //assume ASCII table 256 characters
        int temp = 1;
        for (int i = 0; i < input.length; ++i) {
            for (int j = i+1; j < input.length; ++j) {
                if(input[i]==input[j]){
                    bools[i]=true;
                }
            }
        }
        for (int i = 0; i < input.length; ++i) {
            if(bools[i]){
                input[i] = 0;
            }
        }
        return input;
    }

    public static char[] removeDuplicateCharsWithoutExtraSpace(char[] input) {
		//extra variables are allowed
        if (input.length < 2) {
            return input;
        }
        int k = 1;
        for (int i = 1; i < input.length; ++i) {
            int j = 0;
            for (j = 0; j < k; ++j) {
                if (input[i] == input[j]) {
                    break;
                }
            }
            if (j == k) {
                input[k] = input[i];
                k++;
            }
        }
        input[k] = 0;

        return input;
    }


}
