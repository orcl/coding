public class stringCompress {

  public static void main(String[] args) {
    String input = "aaabbc";
    System.out.println(stringCompress(input));
  }

  private static String stringCompress(String input) {
    if (input == null) return null;
    int count = 0;
    StringBuilder sb = new StringBuilder();
    char[] char_array = input.toCharArray();
    sb.append(char_array[0]);
    count++;

    for (int i = 1; i < char_array.length; i++) {
      if (char_array[i] != char_array[i-1]) {
        sb.append(count);
        sb.append(char_array[i]);
        count=1;
        if(i==char_array.length-1)
          sb.append(count);
      }else {
        count++;
      }
    }//end for loop
    return sb.toString();
  }//end stringCompress

}//end class


