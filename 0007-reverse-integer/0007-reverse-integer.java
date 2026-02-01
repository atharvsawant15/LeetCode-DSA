class Solution {
    public int reverse(int x) {
        double rev = 0;
        while(x != 0){
            double unit_digit = x % 10;
            rev = (rev * 10) + unit_digit;
            if(rev >= Integer.MAX_VALUE || rev <= Integer.MIN_VALUE){
                return 0;
            }
            x = x / 10;
        }
    return (int)rev; 
    }
}
# new