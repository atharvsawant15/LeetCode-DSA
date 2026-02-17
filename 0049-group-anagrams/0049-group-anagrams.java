class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] str_arr = str.toCharArray();
            Arrays.sort(str_arr);
            String sortedString = new String(str_arr);
            map.putIfAbsent(sortedString, new ArrayList<>());
            map.get(sortedString).add(str);
        }
        return new ArrayList<>(map.values());
    }
}