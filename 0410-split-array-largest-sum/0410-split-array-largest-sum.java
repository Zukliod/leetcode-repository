class Solution {
    public boolean isValid(int[] arr, int n, int m, long maxsplit) {
        int stu = 1;
        long pages = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxsplit) {
                return false;
            }
            if (pages + arr[i] <= maxsplit) {
                pages += arr[i];
            } else {
                stu++;
                pages = arr[i];
            }
        }
        return stu <= m;
    }

    public int splitArray(int[] nums, int k) {
         int n = nums.length;
        if (k > n) { 
            return -1;
        }
        
        long sum = 0;
        int maxElement = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (nums[i] > maxElement) {
                maxElement = nums[i];
            }
        }
        
        long res = -1;
        long l = maxElement;
        long r = sum;
        
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (isValid(nums, n, k, mid)) { 
                res = mid;
                r = mid - 1;
            } else { 
                l = mid + 1;
            }
        }
        return (int) res;
    }
}

   