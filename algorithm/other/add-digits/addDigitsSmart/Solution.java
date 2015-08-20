/*
 * hint: (100a + 10b + c) = (a + 99a + b + 9b + c)
 * thus: (100a + 10b + c)%9 = (a + 99a + b + 9b + c)%9 = (a + b + c)%9
 * thus:  num%9  = (a+b+c)%9
 * because a+b+c can't be >= 90, therefore, (a+b+c)%9 < 90, therefore (a+b+c) can't be > than 10
 *
 */

public class Solution {
  public int addDigits(int num) {
    if (num == 0)
      return 0;
    return num%9!=0?num%9:9;
  }
}


