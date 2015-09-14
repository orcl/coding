/* Problem: Meeting rooms
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si<ei), 
 * determine if a person could attend all meetings.
 *
 * for example,
 * given [[0,30],[5,10],[15,20]],
 * return false
 */

class Interval {
  int start;
  int end;
  Interval() { start = 0; end = 0; }
  Interval(int s, int e) {
    start = s;
    end = e;
  }
}//end Interval


public class Solution {

  public boolean canAttendMeeting(Interval[] intervals) {
    if (intervals == null || intervals.length == 0) {
      return  true;
    }
    Arrays.sort(intervals, new Comparator<Interval>() {
      public int compare(Interval i1, Interval i2) {
        if (i1.start == i2.start) {
          return 0;
        }
        return i1.start > i2.start?1:-1;
      }
    });

    for (int i = 1; i < intervals.length; i++) {
      Interval prev = intervals[i-1];
      Interval curr = intervals[i];
      if (prev.end > curr.start) {
        return false;
      }
    }//end for loop
  }//end canAttendMeeting

}//end Solution




