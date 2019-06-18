//quicksort inplace



class quicksort{
	public static void quicksort(int[] arr, int l, int r){
		if(l < r){
			int q = partition(arr,l,r);
			quicksort(arr, l, q-1);
			quicksort(arr, q+1, r);
		}	

	}

	private static int partition(int[] arr, int l, int r){
		int pivot = arr[r];
		int i = l - 1;
		for(int j = l; j < r; j++){
			if(arr[j] <= pivot){
				i++;
				exchange(arr, i+1, j);
			}
		}
		exchange(arr,i+1, r);
		return i+1;
	}

	private static void exchange(int[] arr, int i , int j){
		int tmp = arr[j];
		arr[j] = arr[i];
		arr[i] = tmp;
	}
}