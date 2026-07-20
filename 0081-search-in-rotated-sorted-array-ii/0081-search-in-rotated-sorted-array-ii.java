class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
         while (l < r && nums[l] == nums[l + 1]) ++l;
        while (l < r && nums[r] == nums[r - 1]) --r;
        while(l<=r){
            int mid = l+(r-l)/2;
            if (target == nums[mid]){
                return true;
            }
            if(nums[l]<=nums[mid]){
                if(target>nums[mid] || target<nums[l]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }else{
                if(target<nums[mid] || target>nums[r]){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }
        }
        return false;
    }
}