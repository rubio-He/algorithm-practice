public class singleNumer {

    /*
    Given an array of integers, every element appears three times
     except for one, which appears exactly once. Find that single one.
     */
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int i = 0; i < nums.length; i++){
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;

    }
}
