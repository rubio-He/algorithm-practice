import java.util.*;
public class threesumcloset {
        public int threeSumClosest(int[] nums, int target) {
            int len = nums.length;
            Arrays.sort(nums);//dual-pivot quicksort

            //loCount and hiCount denote your lowest, and higher values closest to target
            int loCount = nums[0] + nums[1] + nums[2], hiCount = nums[len - 3] + nums[len - 2] + nums[len - 1];

            //check for easy(edge case) solution
            if (loCount >= target)
                return loCount;
            if (hiCount <= target)
                return hiCount;

            //iterate through array via incrementing head pointer
            for (int head = 0; head < nums.length - 2; head++) {
                //lo and hi denotes smallest and biggest values of current head iteration
                int lo = nums[head] + nums[head + 1] + nums[head + 2], hi = nums[head] + nums[len - 2] + nums[len - 1];

                if (lo > target) {//if lo is too big, update your hiCount and terminate loop
                    if (hiCount > lo) //
                        hiCount = lo;
                    break;
                } else if (hi < target) { //if hi is too small, update your loCount and skip current iteration
                    if (loCount < hi)
                        loCount = hi;
                    continue;
                }

                //low and high denotes your array index pointers
                int low = head + 1, high = len - 1;
                while (low < high) {
                    int sum = nums[low] + nums[high] + nums[head];
                    if (sum == target) {
                        return target;
                    } else if (sum < target) {
                        if (loCount < sum)
                            loCount = sum;
                        while (++low < len - 1 && nums[low] == nums[low - 1])
                            ;
                    } else {
                        if (hiCount > sum)
                            hiCount = sum;
                        while (--high > head + 1 && nums[high] == nums[high + 1])
                            ;
                    }
                }
            }
            return (hiCount - target) > (target - loCount) ? loCount : hiCount;
        }
}
