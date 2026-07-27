class Solution {
    public int maxWidthRamp(int[] nums) {
        int[] max = new int[nums.length];

        max[nums.length-1] = nums[nums.length-1];

        for(int i=nums.length-2; i>=0; i--){
            max[i] = Math.max(nums[i], max[i+1]);
        }

        int l=0,
            r=0,
            ramp=0;
        
        while(r<nums.length){
            while(l<r && nums[l] > max[r]){
                l++;
            }
            ramp = Math.max(ramp, r-l);
            r++;
        }
        return ramp;
    }
}