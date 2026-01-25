//------------------Time limit Exceeded----------------------
// class Solution {
//     public static boolean palindrome(int num){
//         int rev = 0;
//         int number = num;
//         while(number != 0){
//             int unit = number % 10;
//             rev = (rev * 10) + unit;
//             number = number / 10;
//         }
//         return num == rev;
//     }

//     public long[] kthPalindrome(int[] queries, int intLength) {

//         ArrayList<Long> new_array = new ArrayList<>();

//         int n = intLength;
//         int start = (int)  Math.pow(10, n - 1);
//         int end = (int) Math.pow(10,n) - 1;
//         int last_term = queries[queries.length-1];
//         int cnt_palindrome = 0;

//         for(int i = start;i <= end; i++){
//             if(palindrome(i)){
//                 new_array.add((long) i);
//             }
//         }

//         long[] result = new long[queries.length];
//         for (int i = 0; i < queries.length; i++) {
//             int k = queries[i];
//             if (k <= new_array.size()) {
//                 result[i] = new_array.get(k - 1); 
//             } else {
//                 result[i] = -1;
//             }
//         }

//         return result ;
//     }
// }


//-------------------optimal instead of checking all genrete palindrome-------------------
class Solution {

    private long reverse(long x) {
        long rev = 0;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev;
    }

    public long[] kthPalindrome(int[] queries, int intLength) {

        int halfLen = (intLength + 1) / 2;
        long start = (long) Math.pow(10, halfLen - 1);
        long maxCount = (long) Math.pow(10, halfLen) - start;

        long[] result = new long[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long k = queries[i];

            if (k > maxCount) {
                result[i] = -1;
                continue;
            }

            long firstHalf = start + k - 1;
            long secondHalf;

            if (intLength % 2 == 0) {
                secondHalf = reverse(firstHalf);
            } else {
                secondHalf = reverse(firstHalf / 10);
            }

            result[i] = firstHalf * (long) Math.pow(10, intLength / 2) + secondHalf;
        }

        return result;
    }
}

