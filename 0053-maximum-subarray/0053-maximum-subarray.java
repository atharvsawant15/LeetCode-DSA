class Solution {
    public int maxSubArray(int[] nums) {
        int n =nums.length;
        int max = Integer.MIN_VALUE;

        for(int st=0;st<n;st++){
            int curr_sum = 0;
            for(int end=st;end<n;end++){
                curr_sum += nums[end];
                if(curr_sum > max){
                    max = curr_sum;
                }
            }
        }
    return max;    
    }
}