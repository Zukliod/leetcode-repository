class Solution {
    public boolean check(int k,int[] piles,int h){
        int hours = 0;
        for(int i = 0; i<piles.length;i++){
            hours+= Math.ceil((double)piles[i]/(double)k);            
        }
        if(hours<= h)
        return true;
        else
        return false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        int ans = -1;
        for(int i :piles){
            if(i>max){
                max = i;
            }
        }
        for(int i = 1;i<=max;i++){
            if(check(i,piles,h)){
                ans = i;
                break;
            }
        }
        return ans;
    }
}