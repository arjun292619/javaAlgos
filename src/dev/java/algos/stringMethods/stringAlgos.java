package dev.java.algos.stringMethods;

import java.util.*;

public class stringAlgos {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums1));
        System.out.println(containsDuplicate1(nums1));

        int[] nums2 = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums2)); // Expected output: true
        System.out.println(containsDuplicate1(nums2)); // Expected output: true

        int[] nums3 = {};
        System.out.println(containsDuplicate(nums3)); // Expected output: false
        System.out.println(containsDuplicate1(nums3)); // Expected output: false

        int[] nums4 = {1, 1, 1, 1};
        System.out.println(containsDuplicate(nums4));
        System.out.println(containsDuplicate1(nums4));

        // Test Case 1
        String s1 = "hello";
        String expectedOutput1 = "holle";
        String actualOutput1 = reverseVowels(s1);
        System.out.println("Test Case 1: " + (expectedOutput1.equals(actualOutput1)));

        // Test Case 2
        String s2 = "DesignGUrus";
        String expectedOutput2 = "DusUgnGires";
        String actualOutput2 = reverseVowels(s2);
        System.out.println("Test Case 2: " + (expectedOutput2.equals(actualOutput2)));

        // Test Case 3
        String s3 = "AEIOU";
        String expectedOutput3 = "UOIEA";
        String actualOutput3 = reverseVowels(s3);
        System.out.println("Test Case 3: " + (expectedOutput3.equals(actualOutput3)));

        // Test Case 4
        String s4 = "aA";
        String expectedOutput4 = "Aa";
        String actualOutput4 = reverseVowels(s4);
        System.out.println("Test Case 4: " + (expectedOutput4.equals(actualOutput4)));

        // Test Case 5
        String s5 = "";
        String expectedOutput5 = "";
        String actualOutput5 = reverseVowels(s5);
        System.out.println("Test Case 5: " + (expectedOutput5.equals(actualOutput5)));

        //isPalindrome
        // Test case 1: "A man, a plan, a canal, Panama!"
        // Expected output: true
        System.out.println(isPalindrome("A man, a plan, a canal, Panama!"));

        // Test case 2: "race a car"
        // Expected output: false
        System.out.println(isPalindrome("race a car"));

        // Test case 3: "Was it a car or a cat I saw?"
        // Expected output: true
        System.out.println(isPalindrome("Was it a car or a cat I saw?"));

        // Test case 4: "Madam, in Eden, I'm Adam."
        // Expected output: true
        System.out.println(isPalindrome("Madam, in Eden, I'm Adam."));

        // Test case 5: "empty string"
        // Expected output: true
        System.out.println(isPalindrome(""));

        //isAnagram
        // Test case 1
        String st1 = "listen";
        String t1 = "silent";
        System.out.println(isAnagram(st1, t1)); // Expected output: true

        // Test case 2
        String st2 = "hello";
        String t2 = "world";
        System.out.println(isAnagram(st2, t2)); // Expected output: false

        // Test case 3
        String st3 = "anagram";
        String t3 = "nagaram";
        System.out.println(isAnagram(st3, t3)); // Expected output: true

        // Test case 4
        String st4 = "rat";
        String t4 = "car";
        System.out.println(isAnagram(st4, t4)); // Expected output: false

        // Test case 5
        String st5 = "";
        String t5 = "";
        System.out.println(isAnagram(st5, t5)); // Expected output: true

        //shortest distance
        //Test case 1
        String[] words1 = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String word11 = "fox";
        String word21 = "dog";
        System.out.println(shortestDistance(words1, word11, word21));

        // Test case 2
        String[] words2 = {"a", "b", "c", "d", "a", "b"};
        String word12 = "a";
        String word22 = "b";
        System.out.println(shortestDistance(words2, word12, word22));

        // Test case 3
        String[] words3 = {"a", "c", "d", "b", "a"};
        String word13 = "a";
        String word23 = "b";
        System.out.println(shortestDistance(words3, word13, word23));

        // Test case 4
        String[] words4 = {"a", "b", "c", "d", "e"};
        String word14 = "a";
        String word24 = "e";
        System.out.println(shortestDistance(words4, word14, word24));

        //number of good pairs
        int[] nums11 = {1, 2, 3, 1, 1, 3};
        int result1 = numGoodPairs(nums11);
        System.out.println("Result 1: " + result1 + " (Expected: 4)");

        int[] nums22 = {1, 1, 1, 1};
        int result2 = numGoodPairs(nums22);
        System.out.println("Result 2: " + result2 + " (Expected: 6)");

        int[] nums33 = {1, 2, 3};
        int result3 = numGoodPairs(nums33);
        System.out.println("Result 3: " + result3 + " (Expected: 0)");
    }

    public static boolean containsDuplicate(int[] dataset) {
        for (int i = 0; i < dataset.length; i++) {
            for (int j = i + 1; j < dataset.length; j++) {
                if (dataset[i] == dataset[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsDuplicate1(int[] dataset) {
        Set<Integer> uniqueSet = new HashSet<>();
        for (int el : dataset) {
            if (!uniqueSet.contains(el)) {
                uniqueSet.add(el);
            } else {
                return true;
            }
        }
        return false;
    }

    public static String reverseVowels(String sentence) {
        String vowelList = "aeiouAEIOU";
        char[] sChars = sentence.toCharArray();
        int i = 0;
        int j = sentence.length() - 1;
        while (i < j) {
            while (i < j && vowelList.indexOf(sChars[i]) == -1) {
                i++;
            }

            while (i < j && vowelList.indexOf(sChars[j]) == -1) {
                j--;
            }
            char temp = sChars[i];
            sChars[i] = sChars[j];
            sChars[j] = temp;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(sChars));
        return new String(sChars);
    }

    public static boolean isPalindrome(String sentence) {
        int start = 0;
        int end = sentence.length() - 1;
        while (start < end) {
            while (!Character.isLetterOrDigit(sentence.charAt(start))) {
                start++;
            }
            while (!Character.isLetterOrDigit(sentence.charAt(end))) {
                end--;
            }
            if (Character.toLowerCase(sentence.charAt(start)) != Character.toLowerCase(sentence.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            freqMap.put(s1.charAt(i), freqMap.getOrDefault(s1.charAt(i), 0) + 1);
            freqMap.put(s2.charAt(i), freqMap.getOrDefault(s2.charAt(i), 0) - 1);
        }

        for (char c : freqMap.keySet()) {
            if (freqMap.get(c) != 0) {
                return false;
            }
        }
        return true;
    }

    public static int shortestDistance(String[] words, String word1, String word2) {
        int shortestDist = words.length;
        int pos1 = -1;
        int pos2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                pos1 = i;
            }
            if (words[i].equals(word2)) {
                pos2 = i;
            }
            if (pos1 != -1 && pos2 != -1) {
                shortestDist = (Math.min(shortestDist, Math.abs(pos2 - pos1)));
            }
        }
        return shortestDist;
    }

    public static int numGoodPairs(int[] elementArr) {
        int pairCount = 0;
        HashMap<Integer, ArrayList<Integer>> elementMap = new HashMap<>();

        for (int i = 0; i < elementArr.length; i++) {
            if (elementMap.get(elementArr[i]) != null) {
                pairCount += 1;
                elementMap.get(elementArr[i]).add(i);
            } else {
                elementMap.put(elementArr[i], new ArrayList<>(List.of(i)));
            }
        }
        System.out.println(elementMap);
        return pairCount;
    }
}
