class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Count characters in magazine
        for(char ch : magazine.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        // Check ransomNote
        for(char ch : ransomNote.toCharArray()){
            if(!map.containsKey(ch) || map.get(ch) == 0){
                return false;  // character missing or used up
            }
            map.put(ch, map.get(ch) - 1); // use one occurrence
        }
        
        return true; // all characters are present
    }
}
