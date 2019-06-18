import java.util.*;
public class threeSum {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> threeSum(int[] nums) {
            int len = nums.length;
            if (len < 3)
                return res;

            Arrays.sort(nums);  //sort the array first

            int zeroCount; //the appearing times of 0
            int lastNeg = Arrays.binarySearch(nums, 0); //search the position of 0; it also means the position of the last negative number in array
            int firstPos = lastNeg; //the position of the first positive number in array
            if(lastNeg < 0){    //0 not found
                zeroCount = 0;
                lastNeg = -(lastNeg + 1) - 1;//see the Java api
                firstPos = lastNeg + 1;
            }
            else{               //found
                while(lastNeg > -1 && nums[lastNeg] == 0) //skip all 0
                    lastNeg--;
                while(firstPos < len && nums[firstPos] == 0)
                    firstPos++;
                zeroCount = firstPos - lastNeg - 1;
            }

            int min;
            int max;
            int[] hash;
            min = nums[0];
            max = nums[len - 1];
            max = Math.max(Math.abs(max), Math.abs(min)); //to allocate enough space to avoid check in if statement
            min = -max;
            hash = new int[max - min + 1];
            for (int v : nums) { //hash and count appearing times of every num
                hash[v - min]++;
            }

            if (zeroCount >= 3) { // (0 appears 3 times at least)
                addTriplets(0, 0, 0);
            }
            if (zeroCount > 0 ) { // (0 appears 1 times at least)
                for (int i = firstPos; i < len; i++) { //traverse all the positive numbers to see whether there is a negative number whose absolute value equals to the positive number
                    if(i > firstPos && nums[i] == nums[i - 1]) //skip the same elements
                        continue;
                    if (hash[-nums[i] - min] > 0)
                        addTriplets(0, nums[i], -nums[i]);
                }
            }

            // one positive number and two negetive numbers
            for (int i = firstPos; i < len; i++) { //traverse all the positive numbers to find whether there are two negative numbers to make the 3 numbers added up to 0
                if(i > firstPos && nums[i] == nums[i - 1]) //skip the same elements
                    continue;
                int half;   //we can traverse only half of the positive numbers
                if(nums[i] % 2 != 0)
                    half = -(nums[i] / 2 + 1);
                else{
                    half = -(nums[i] / 2);
                    if(hash[half - min] > 1)
                        addTriplets(nums[i], half, half);
                }
                for(int j = lastNeg; j > -1 && nums[j] > half; j--){
                    if(j < lastNeg && nums[j] == nums[j + 1])
                        continue;
                    if(hash[(-nums[i] - nums[j]) - min] > 0)
                        addTriplets(nums[i], nums[j], -nums[i] - nums[j]);
                }
            }

            // one negative number and two positive numbers
            for (int i = lastNeg; i > -1; i--) { //traverse all the negative numbers to find whether there are two positive numbers to make the 3 numbers added up to 0
                if(i < lastNeg && nums[i] == nums[i + 1])//skip the same elements
                    continue;
                int half; //we can traverse only half of the negative numbers
                if(nums[i] % 2 != 0)
                    half = -(nums[i] / 2 - 1);
                else{
                    half = -(nums[i] / 2);
                    if(hash[half - min] > 1)
                        addTriplets(nums[i], half, half);
                }
                for(int j = firstPos; j < len && nums[j] < half; j++){
                    if(j > firstPos && nums[j] == nums[j - 1])
                        continue;
                    if(hash[(-nums[i] - nums[j]) - min] > 0)
                        addTriplets(nums[i], nums[j], -nums[i] - nums[j]);
                }
            }
            return res;
        }

        public void addTriplets(int a, int b, int c) {
            List<Integer> triplets = new ArrayList<>(3);
            triplets.add(a);
            triplets.add(b);
            triplets.add(c);
            res.add(triplets);
        }

}
