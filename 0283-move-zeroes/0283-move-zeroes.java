// class Solution {
//     public void moveZeroes(int[] nums) {
//         int i=0;
//         int j=1;
//         while(j<nums.length){
//             if(nums[i] == 0 && nums[j] != 0){
//                 nums[i] = nums[j];
//                 nums[j] = 0;
//                 i++;
//             }
//             j++;
//         }
//     }
// }

class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 1;

        while (j < nums.length) {

            if (nums[i] != 0) {
                i++;
                j = Math.max(j, i + 1);
            }
            else if (nums[j] != 0) {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
                j++;
            } 
            else {
                j++;
            }
        }
    }
}
