public class Test {

  public static void main(String[] args) {
  
    int[] A = new int[]{-1,3,-4,5,1,-6,2,1};

    int result = -1; 

    int[] left  = new int[A.length];
    int[] right = new int[A.length];

    left[0] = 0;
    right[A.length -1] = 0;

    for (int i=1; i < A.length; i++){
      left[i] = left[i-1] + A[i-1];
      right[A.length-i-1] = right[A.length - i] + A[A.length-i];
    }

    for (int i =0 ; i < A.length; i++) {
      if (left[i] - right[i] == 0) {
        result = i;
        break;
      }
    }
  
    System.out.println(result);

  }
}
