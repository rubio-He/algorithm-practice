/**
 * Created by Hobbes on 6/16/17.
 */
import java.util.*;
public class subSetsII {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        helper(res, nums, new LinkedList<Integer>(), 0);
        return res;
    }
    public static void helper(List<List<Integer>> res, int[] nums, List<Integer> subsets, int i){
        if(i > nums.length) return;
        res.add(subsets);
        for(int index = i; index < nums.length; index++){
            if(index != i && nums[index] == nums[index-1] ) continue;
            subsets.add(nums[index]);
            List<Integer> ll = new LinkedList<>(subsets);
            helper(res, nums,ll, index + 1);
            subsets.remove(ll.size() - 1);
        }
    }
    public static void main(String[] args){
        int[] nums = new int[]{1,2,2};
        subsetsWithDup(nums);
    }
}
