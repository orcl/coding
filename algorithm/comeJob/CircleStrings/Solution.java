/* given an array of strings, find if all the strings can be chained to form a circle.
 * two strings s1 and s2 can be chained, iff the last letter of s1 is identical to the first letter of s2.
 * for example, "abc" and "cd" can be chained.
 * "abc" and "dz" can not be chained.
 *
 * example input: arr[] = "aaa", "bbb", "baa", "aab"
 * output: true,
 *
 * the given input strings can be chained to form a circle, the strings can be chained as "aaa", "aab", "bbb", "baa".
 */

import java.util.*;


public class Solution {

    public static void main(String[] args) {
 
        List<String> path  = new ArrayList<String>();
        List<String> path1 = new ArrayList<String>();
        List<String> path2 = new ArrayList<String>();
        String[] input  = new String[]{"aaa","bbb","baa","aab"};
        String[] input1 = new String[]{"aa","bb","cc","dd"};
        String[] input2 = new String[]{"ab","de","bb","ef","bcd"};

        print(input);
        System.out.println("the result of helper(input) is: " + helper(input, path, input[0]));
        System.out.println();

        print(input1);
        System.out.println("the result of helper(input1) is: " + helper(input1, path1, input1[0]));
        System.out.println();

        print(input2);
        System.out.println("the result of helper(input2) is: " + helper(input2, path2, input2[0]));
        System.out.println();



        print(input);
        System.out.println("the result of helper1(input) is: " + helper1(input,0,""));
        System.out.println();

        print(input1);
        System.out.println("the result of helper1(input1) is: " + helper1(input1,0,""));
        System.out.println();

        print(input2);
        System.out.println("the result of helper1(input2) is: " + helper1(input2,0,""));
        System.out.println();


    }


    private static boolean helper(String[] input, List<String> path, String prevWord) {
        if (path.size() >= input.length-1) {
            return true;
        }
        for (int i = 0; i < input.length; i++) {
            if (path.contains(input[i])) {
                continue;
            }
            if (prevWord.charAt(prevWord.length()-1) == input[i].charAt(0)) {
                //compare the last character of previous word to first character of current word
                path.add(input[i]);
                if (helper(input,path, input[i])) {
                    return true;
                }
                path.remove(path.size()-1);
            }
        }
        return false;
    }

    private static boolean helper1(String[] input, int index, String prevWord) {
        //System.out.print(prevWord + " , ");
        if (index >= input.length) {
            return true;
        }
        for (int i = index; i < input.length; i++) {
            if (prevWord == "" || prevWord.charAt(prevWord.length()-1) == input[i].charAt(0)) {
                swap(input, index, i);
                //System.out.print(input[i] + " , ");
                if (helper1(input, index+1, input[index])) {
                    return true;
                }
                swap(input, index, i);
            }
        }
        return false;
    }

    private static void swap(String[] input, int left, int right) {
        String tmp   = input[left];
        input[left]  = input[right];
        input[right] = tmp;
    }


    private static void print(String[] array) {
        String input = "";
        for (int i = 0; i < array.length; i++) {
            input += array[i] + ",";
        }
        System.out.println(input);

    }


}
