import java.util.*;

public class Main {
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

        for(char c: freqMap.keySet()){
            if(freqMap.get(c)!=0){
                return false;
            }
        }
        return true;
    }
}