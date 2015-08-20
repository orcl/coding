public class Solution {
  
  public int addDigits(int num) {
    return helper(num);
  }

  public int helper(int num) {
    if (num < 10) {
      return num;
    }
    int sum = 0;
    while (num/10 >=1) {
      sum = sum + num%10;
      num = num / 10;
    }//end while
    if (sum+num >= 10) {
      return helper(sum + num);
    }else {
      return sum + num;
    }
  }

}
