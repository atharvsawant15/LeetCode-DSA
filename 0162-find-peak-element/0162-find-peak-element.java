// class Solution {
//     public int findPeakElement(int[] nums) {
//        for(int i=1;i < nums.length-1;i++){
//         if(nums[i-1] < nums[i] && nums[i+1] < nums[i]){
//             return i;
//         }
//        } 
//        return 0;
//     }
// }

class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start; // or end (same)
    }
}