public class plusOne {

  public int[] plusOne(int[] digits) {
  
    ArrayList<Integer> result = new ArrayList<Integer>();

    int carry = 1;
    for (int i = digits.length - 1; i>=0; i--) {
      int total = 0;
      total = carry + digits[i];
      if (total == 10) {
        int temp = total - 10;
        carry = 1;
        result.add(0,temp);
        if (i==0) {
          result.add(0,1);
        }
      }else {
        carry = 0;
        result.add(0,total);
      }
    }//end for loop

    int[] result_array = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      result_array[i] = result.get(i);
    }
    return result_array;
  }
}//end class plusOne
