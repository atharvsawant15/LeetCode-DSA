class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        
        for (int i = 1; i < n; i++) {
            if (nums[i] < first) {
                second = first;
                first = nums[i];
            } else if (nums[i] < second) {
                second = nums[i];
            }
        }
        
        return nums[0] + first + second;
    }
}