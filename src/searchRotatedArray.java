public class searchRotatedArray {
    public static int search(int[] arr, int target){
        // 5670123
        int l = 0;
        int h = arr.length - 1;
        while(l <= h){
            //24
            int m = (l+h)/2;
            if(arr[m] == target) return m;
            if(arr[m] < arr[h]){
                if(target <= arr[h] && target > arr[m]) l = m + 1;
                else h = m - 1;
            }//4567812
            else if(arr[m] > arr[h]){
                if(target < arr[m] && target >= arr[l]) h = m - 1;
                else l = m + 1;
            }
            else h--;
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.print(search(new int[]{5,6,7,0,1,2,3}, 2));
    }
}
