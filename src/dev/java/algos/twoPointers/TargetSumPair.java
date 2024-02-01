package dev.java.algos.twoPointers;

public class TargetSumPair {
    public static void main(String[] args) {
        int[] result = search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }

    private static int[] search(int[] nums, int sum) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == sum) {
                return new int[]{start, end};
            }

            if(nums[start] + nums[end] > sum){
                end--;
            } else {
                start++;
            }
        }
        return new int[]{-1, -1};
    }
}
