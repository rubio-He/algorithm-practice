import java.util.*;

public class Contains_Duplicate_III {

    private static long getID(long x, int w){
        return x < 0 ? (x+1)/w - 1 : x / w;
    }
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t<0) return false;
        Map<Long, Long> m = new HashMap<>();
        int w = t +1;
        for(int i = 0;  i< nums.length ; i++){
            long id = getID((long)nums[i], w);

            if(m.containsKey(id)) return true;

            if(m.containsKey(id-1) && Math.abs(nums[i] - m.get(id-1) )< w) return true;
            if(m.containsKey(id+1) && Math.abs(nums[i] - m.get(id+1) )< w) return true;

            m.put(id, (long)nums[i]);
            if(i >= k ) m.remove(getID((long)nums[i-k],w));

        }
        return false;
    }


    public static void main(String[] args){
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,3,1}, 1, 1));
    }
}
