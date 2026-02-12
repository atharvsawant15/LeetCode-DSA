class Solution {

    public String reverseWords(String s) {
        // Split by one or more spaces
        String[] words = s.trim().split("\\s+");  
        
        // Reverse the array of words
        int start = 0, end = words.length - 1;
        while (start < end) {
            String temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start++;
            end--;
        }

        // Join words with single space
        return String.join(" ", words);
    }

}
