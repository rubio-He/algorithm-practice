/**
 * Created by Hobbes on 7/24/17.
 */
public class Binary_Indexd_Tree {
    int[] btree;
    int[] arr;

    public Binary_Indexd_Tree(int[] nums){
        btree = new int[nums.length + 1];
        arr = nums;

        for(int i = 0; i< nums.length; i++){
            add(i+1,nums[i]);
        }
    }


    void add(int i, int val){
        for(int j = i; j < btree.length; j = j+(j&-j)){
            btree[j] += val;
        }
    }

    void update(int i, int val){
        add(i+1, val - arr[i]);
        arr[i] = val;
    }

    public int sumRange(int i, int j){
        return sumHelper(j+1) - sumHelper(i);
    }

    int sumHelper(int i){
        int sum = 0;
        for(int j = i; i >=1; j = j - (j & -j)){
            sum += btree[j];
        }
        return sum;
    }
}
