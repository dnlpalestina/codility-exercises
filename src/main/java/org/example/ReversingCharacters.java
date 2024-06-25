package org.example;

public class ReversingCharacters {
    public static String reverse(String s) {
        // Convert the string to a character array
        char[] charArray = s.toCharArray();

        // Initialize two pointers
        int left = 0;
        int right = charArray.length - 1;

        // Loop until the two pointers meet
        while (left < right) {
            // Swap the characters at the left and right pointers
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            // Move the pointers towards each other
            left++;
            right--;
        }

        // Convert the character array back to a string and return it
        return new String(charArray);
    }

    public static void main(String[] args) {
        String original = "hello";
        String reversed = reverse(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }
}
