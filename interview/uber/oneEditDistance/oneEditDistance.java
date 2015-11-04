public class oneEditDistance {

    public boolean isOneEditDistance(String s, String t) {
    
        if (s == null || t == null) {
            return false;
        }

        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }

        if (s.length() == t.length()) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    count++;
                }
                if (count > 1) {
                    return false;
                }
            }
            return count==1;
        }else {
            String ss, ls;
            if (s.length() < t.length()) {
                ss = s;
                ls = t;
            }else {
                ss = t;
                ls = s;
            }
            int i = 0, j = 0;
            int count = 0;
            while (i < ss.length() && j < ls.length()) {
                if (ss.charAt(i) != ls.charAt(j)) {
                    count++;
                    j++;
                    if (count > 1) {
                        return false;
                    }
                }else {
                    i++;
                    j++;
                }
            }
            return true;
        
        }//end if else
    }//end isOneEditDistance
}//end class
