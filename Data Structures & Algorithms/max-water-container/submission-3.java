class Solution {
    public int maxArea(int[] heights) {
    int left=0;
    int right=heights.length-1;
    int maxvol=0;
    while(left<right){
        int height=Math.min(heights[left],heights[right]);
        int currentvol = height * (right - left);
        maxvol=Math.max(currentvol,maxvol);
        if(heights[left]<heights[right]){
            left++;
        }
        else{
            right--;
        }

    }
return maxvol;
        
    }
}
