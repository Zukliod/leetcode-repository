class Solution {
    private static boolean canPlacebuckets(int[] arr, int buckets, int minDist) {
        int Count = 1;             
        int lastPlacedPosition = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastPlacedPosition >= minDist) {
                Count++;
                lastPlacedPosition = arr[i]; 
            }
            
            if (Count >= buckets) {
                return true;          
            }
        }
        return false;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        int n = position.length;
        int low = 1;                  
        int high = position[n - 1] - position[0]; 
        int result = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canPlacebuckets(position, m, mid)) {
                result = mid;         
                low = mid + 1;        
            } else {
                high = mid - 1;       
            }
        }
        return result;
    }
}