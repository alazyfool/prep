import java.util.Arrays;

public class RemoveDuplicatesII {
    public static void main(String[] args) {
        Solution15 sol = new Solution15();
        int[] arr = {1,1,1,2,2,3,3,3,3,3,4,5,5,5};
        int finalK = sol.removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));
//        System.out.println(finalK);

    }
}

class Solution15 {
    public int removeDuplicates(int[] nums) {

        int pointer1, pointer2;
        int maxToExist = 2;
        int current = -1;
        int k = 0;

        for (pointer1 = 0, pointer2 = 0; pointer1 < nums.length && pointer2 < nums.length;) {
            if (nums[pointer2] != current) {
                current = nums[pointer2];
                maxToExist = 1;
                nums[pointer1] = nums[pointer2];
                pointer1++;
                k++;
            } else if (maxToExist != 0) {
                nums[pointer1] = nums[pointer2];
                pointer1++;
                maxToExist--;
                k++;
            }
            pointer2++;
        }

        return k;
    }
}