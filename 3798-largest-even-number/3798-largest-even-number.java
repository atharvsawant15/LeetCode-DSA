class Solution {
    public String largestEven(String s) {
        if (s == null || s.length() == 0) return "";

        for(int i = s.length()-1;i>=0;i--){
            int digit = s.charAt(i) - '0';
            if(digit % 2 == 0 ){
                return s.substring(0,i+1);
            }
        }
        return "";
    }
}