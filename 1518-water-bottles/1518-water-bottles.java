class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int n = numBottles;
        int full = 0;
        int empty = 0;
        while(n > 0){
            full += n;
            empty += n;
            n = empty / numExchange;
            empty = empty % numExchange;
        }
        return full;        
    }
}