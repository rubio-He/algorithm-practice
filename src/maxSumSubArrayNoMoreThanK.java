
import java.util.*;
public class maxSumSubArrayNoMoreThanK {
    private int maxSumSubArray(int[] a , int k){
        int max = Integer.MIN_VALUE;
        int sumj = 0;
        TreeSet<Integer> s = new TreeSet();
        s.add(0);

        for(int i=0;i<a.length;i++){
            int t = sumj + a[i];
            sumj = t;
            Integer gap = s.ceiling(sumj - k);
            if(gap != null) max = Math.max(max, sumj - gap);
            s.add(t);
        }

        return max;
    }

//****************2D

    int res = Integer.MIN_VALUE;
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[] row = new int[m];
        for (int i = 0; i < n; i++) {
            int[] tempRow = new int[m];
            for (int j = i; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    tempRow[l] += matrix[l][j];
                    row[l] = (l == 0 ? 0 : row[l - 1]) + tempRow[l];
                }
                mergeSort(row, 0, m - 1, k);
                if (res == k) return k;
            }
        }
        return res;
    }
    private void mergeSort(int[] row, int start, int end, int bound) {
        if (start == end) {
            if (row[start] <= bound) res = Math.max(res, row[start]);
            return;
        }
        int mid = start + (end - start) / 2, index = 0;
        mergeSort(row, start, mid, bound);
        mergeSort(row, mid + 1, end, bound);
        int[] temp = new int[end - start + 1];
        for (int i = start, j = mid + 1, k = mid + 1; i <= mid; i++) {
            while (j <= end && row[j] - row[i] <= bound) j++;
            if (j > mid + 1) res = Math.max(res, row[j -1] - row[i]);
            while (k <= end && row[k] < row[i]) temp[index++] = row[k++];
            temp[index++] = row[i];
        }
        System.arraycopy(temp, 0, row, start, index);
    }
}
