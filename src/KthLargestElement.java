public class KthLargestElement {
    static int findKthLargestELement(int[] arr, int l, int r, int k){
        if(k > 0 && k <= r - l + 1){
            int pos = partition(arr, l , r);
            if(pos - l == k - 1) return arr[pos];
            if(pos - l > k - 1) return findKthLargestELement(arr, l,pos-1, k);
            return findKthLargestELement(arr,pos+1,r,k-pos+l-1);
        }
        return Integer.MAX_VALUE;
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(int[] arr, int l, int r){
        int x = arr[r] , i = l;
        for(int j = l; j <= r-1; j++){
            if(arr[j] <= x ){
                swap(arr,i,j);
                i++;
            }
        }
        swap(arr,i,r);
        return i;
    }
    public static void main(String[] args){
        int arr[] = {12, 3, 5, 7, 4, 19, 26};
        System.out.print(findKthLargestELement(arr,0,6,3));
    }

}

