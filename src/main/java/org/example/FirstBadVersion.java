//public class FirstBadVersion {
//
//    public static void main(String[] args) {
//        Solution2 obj = new Solution2();
////        System.out.println(obj.isBadVersion(1));
//        System.out.println(obj.firstBadVersion(1182691386));
//    }
//}
//
//
//class Solution {
//    public int firstBadVersion(int n) {
//        long low = 0;
//        long high = n;
//        long mid = low + high/2;
//        int answer = n;
//
//        while (low <= high) {
//            if (isBadVersion((int)mid)) {
//                if (mid < answer) {
//                    answer =  (int)mid;
//                }
//                high = mid - 1;
//                mid = (low + mid) / 2;
//                // if bad version
//            } else {
//                // if good version
//                low = mid + 1;
//                mid = (mid + high) / 2;
//            }
//        }
//        return answer;
//    }
//
//
//    boolean isBadVersion(int n) {
//        if (n < 662351799) {
//            return false;
//        }
//        return true;
//    }
//}