package dev.java.algos.twoPointers;

import java.util.Arrays;

public class NonDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 3, 3, 6, 9, 9};
//        System.out.println(removeDuplicate(arr)); // Output: 4 (Non-duplicate elements: 2, 3, 6, 9)
        System.out.println(removeDuplicate1(arr)); // Output: 4 (Non-duplicate elements: 2, 3, 6, 9)
        arr = new int[]{2, 2, 2, 11};
//        System.out.println(removeDuplicate(arr)); // Output: 2 (Non-duplicate elements: 2, 11)

        arr = new int[]{2, 2, 2, 11};
        System.out.println(removeDuplicate1(arr)); // Output: 2 (Non-duplicate elements: 2, 11)

    }

    private static int removeDuplicate(int[] numList) {
        int placeHolder = 1;
        for (int i = 1; i < numList.length; i++) {
            if (numList[i - 1] != numList[i]) {
                numList[placeHolder] = numList[i];
                placeHolder += 1;
            }
        }
        return placeHolder;
    }

    private static int removeDuplicate1(int[] numList) {
        int position = 1;
        System.out.println("int array:" + Arrays.toString(numList));
        for (int i = 0; i < numList.length - 1; i++) {
            if (numList[i] != numList[i + 1]) {
                numList[position] = numList[i + 1];
                position += 1;
            }
        }
        System.out.println("int array:" + Arrays.toString(numList));
        return position;
    }
}
