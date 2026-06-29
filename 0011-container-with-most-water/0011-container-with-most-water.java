class Solution {
    public int maxArea(int[] height) {
        int area = -1;
        int i = 0;
        int j = height.length-1;
        while(i<j){
            int max = height[i]<height[j]?height[i]:height[j];
            int breadth = j-i;
            area = area<(max*breadth)?(max*breadth):area;
            if(height[i]<=height[j]){
            i++;}
            else{
            j--;}            
        }
        return area;
    }
}