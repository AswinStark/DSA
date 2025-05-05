package com.aswinstark.patterns.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_002 {

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int pivot = 0; pivot<nums.length; pivot++){
            if(nums[pivot]>0){
                break;
            }

            if(pivot>0 && nums[pivot]==nums[pivot-1]){
                continue;
            }

            int left = pivot+1;
            int right = nums.length -1;

            while(left<right) {
                int sum = nums[pivot] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[pivot], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }

        }
        return result;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] testCases = {
                {-1, 0, 1, 2, -1, -4},
                {1, 2, 3, 4, 5},
                {0, 0, 0, 0},
                {-4, -1, -1, 0, 1, 2, 2},
                {-10, -7, -3, -1, 0, 3, 7, 10},
                {-3, -5, -7, -9}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            System.out.println("\nTest Case " + (i + 1) + ":\n\tInput: " + Arrays.toString(nums));
            List<List<Integer>> result = threeSum(nums);
            System.out.print("\tOutput: ");
            System.out.println(result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
