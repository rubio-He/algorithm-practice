import java.util.*;

class Select_K_Random_reservoir_sampling {
    static void selectKItems(int stream[], int n, int k)
    {
        int i = 0;
        int[] reservoir = new int[k];
        for(; i < k; i++){
            reservoir[i] = stream[i];
        }
        Random rand = new Random();

        for(;i < n; i++){
            int j = rand.nextInt(i+1);
            if(j < k){
                reservoir[j] = stream[i];
            }
        }

    }
}
