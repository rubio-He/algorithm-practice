import java.util.*;
public class Binary_Heap {
    private int lastIndex;
    private int[] heap;

    public Binary_Heap(int size){
        heap = new int[size];
        lastIndex = -1;
    }

    public Binary_Heap(int[] a ){
        heap = new int[a.length];
        for(int i = 0; i < a.length; i++){
            heap[i] = a[i];
        }
        lastIndex = a.length - 1;
        heapify();
    }

    private void percUp(int i){
        while(i>=0){
            if(heap[(i-1)/2] < heap[i]){
                int tmp = heap[(i-1)/2];
                heap[(i-1)/2] = heap[i];
                heap[i] = tmp;
                i = (i-1)/2;
            }
            else break;
        }
    }

    private void percDown(int i){
        while(i <= lastIndex){
            int min = heap[i];
            if(2 * i + 1 <= lastIndex && heap[2*i + 1] < heap[min]) min = 2*i + 1;
            if(2 * i + 2 <= lastIndex && heap[2*i + 2] < heap[min]) min = 2*i + 2;
            if(min == i) break;
            else{
                int tmp = heap[min];
                heap[min] = heap[i];
                heap[i] = tmp;
                i = min;
            }
        }
    }

    public void heapify(){
        for(int i = lastIndex / 2; i >= 0; i--){
            percDown(i);
        }
    }

    public static void main(String[] args){
        Binary_Heap heap = new Binary_Heap(new int[]{6,5,7,4,3,1,3,5,7,8,2});
        for(int i = 0; i < heap.heap.length; i++){
            System.out.println(heap.heap[i]);
        }
    }

}
