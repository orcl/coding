public class test {

  public static void main(String[] args) {
  
    int[] array = {-1,1,3,3,3};
    
    System.out.println("total result " + solution(array)); 
  }

  public static int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;
        int count = 0; //record same diff number
        int prevdiff = Integer.MIN_VALUE;
        int diff     = 0;
        
        int prev = -1;
        int left = 0;
        int right = A.length;
        
        while (left < A.length-1) {
            prev++;
            left++;
            
            diff = A[left] - A[prev];
            System.out.println("diff is: " + diff);

            if (prevdiff != Integer.MIN_VALUE) {
                if (prevdiff == diff) {
                    count++;
                    System.out.println("count is: " + count); 
                    if (count >=2) {
                        result++;
                    }
                  
                }else {
                   System.out.println(count);
                    count = 0;
                }
            }else {
              count++;
            }
            prevdiff = diff;
        }//end while
        
        if (result > 1000000000)
            return -1;
        
        return result;
    }


}
