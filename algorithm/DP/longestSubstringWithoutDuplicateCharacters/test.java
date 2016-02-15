import java.util.*;

public class test {
    
    public static void main(String[] args) {
        
        HashSet<Character> set = new HashSet<Character>();
        String input = "bbc";
        for (int i = 0; i < input.length(); i++) {
            if (!set.add(input.charAt(i))) {
                System.out.println("we've found a duplicate character.");
            }
        }

    }//end main
}//end class test
