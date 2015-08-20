import java.util.*;

public class NQueen {
 
    public static void main(String[] args) {
      solveNQueens(4);
    }

    public static List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> result = new ArrayList<>();
        if (n < 1) {
            return result;
        }
        
        ArrayList<String> rows = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
          rows.add("");
        }
        int rowNum = 0;
        solutions(rowNum, n, rows, result);

        return result;
    }
    
    
    // DFS soluve question
    private static void solutions(int stRow, int n, ArrayList<String> rows, ArrayList<List<String>> result){
        if (stRow == n){

            ArrayList<String> tmp = new ArrayList<String>();
            tmp.addAll(rows);
            System.out.println(rows);
            result.add(tmp);
            return;
        }
        
        for(int col=0; col<n; col++){
          //here it doesn't matter if the solution starting from current column work out or not, 
          //if it doesn't work out, the result arraylist simply doesn't add this solution.
          //
            if (!isValid(col, stRow,  rows)){
                continue;
            }
            
            char[] chars=new char[n];
            Arrays.fill(chars, '.');
            chars[col]='Q';
 
            rows.set(stRow,new String(chars));
            solutions(stRow+1, n, rows, result);
            
        }
        
    }
    
    // check if current col has conflit with previous Q
    private static boolean isValid(int col,int stRow,  ArrayList<String> rows){
        // checkColumn
        for (int i=0; i<stRow; i++){
            int qCol=rows.get(i).indexOf("Q");
            
            if (qCol==col){
                return false;
            }
            
            int rowDistance=Math.abs(stRow-i);
            int colDistance=Math.abs(col-qCol);
            
            if (rowDistance==colDistance){
                return false;
            }
        }
        return true;
    }
    
}
