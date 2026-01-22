class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        if (nums.length == 1 || nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        int si = 1;
        int ei = nums.length - 2;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (nums[mid] > nums[mid + 1] && nums[mid] < nums[mid - 1]) {
                ei = mid - 1;
            } else if (nums[mid] < nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                si = mid + 1;
            } else if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            }else{
                ei--;  
            }
        }
        return -1; 
    }
}    