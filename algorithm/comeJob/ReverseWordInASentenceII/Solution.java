import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String a = " a";
        String b = " a ";
        String c = "a ";
        check(a);
        check(b);
        check(c);

    }//end main

    public static String reverseWords(String input) {
        // Write your solution here.
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] char_array = input.toCharArray();
        reverse(char_array,0,char_array.length-1);
        int left = 0;
        int right = char_array.length - 1;
        //get rid of starting space character
        while (char_array[left] == ' ') {
            left++;
        }

        //get rid of trailing space character
        while (char_array[right] == ' ') {
            right--;
        }

        //now we have left and right pointers.
        int size = right-left+1;
        char[] new_array = new char[size];
        for (int i = left; i <= right; i++) {
            new_array[i-left] = char_array[i];
        }
        int start = 0;
        for (int i = 0; i < new_array.length; i++) {
            if (new_array[i] != ' ' && (i == 0 || new_array[i-1] == ' ')) {
                start = i;
            }
            if (new_array[i] != ' ' && (i == new_array.length - 1 || new_array[i+1] == ' ')) {
                reverse(new_array, start, i);
            }
        }//end for loop
        return new String(new_array);

    }//end reverseWords

    private static void reverse(char[] array, int left, int right) {
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    private static void check(String input) {
        String result = reverseWords(input);
        System.out.println("input is ="+input+"= result is: =" + result+"=");
    }



}//end class 


