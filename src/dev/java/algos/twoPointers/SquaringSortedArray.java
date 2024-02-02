package dev.java.algos.twoPointers;

public class SquaringSortedArray {
    public static void main(String[] args) {
        int[] result = sortedSquares((new int[] { -2, -1, 0, 2, 3 }));
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = sortedSquares((new int[] { -3, -1, 0, 1, 2 }));
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }

    private static int[] sortedSquares(int[] numList) {
        int[] squares = new int[numList.length];
        int left = 0;
        int right = numList.length - 1;
        int maxIndex = numList.length - 1;
        while (left < right) {
            int leftSq = numList[left] * numList[left];
            int rightsq = numList[right] * numList[right];

            if (leftSq > rightsq) {
                squares[maxIndex] = leftSq;
                left++;
            } else {
                squares[maxIndex] = rightsq;
                right--;
            }
            maxIndex--;
        }
        return squares;
    }
}
