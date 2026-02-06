class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int prefix[] = new int [n];
        int sufix[] = new int [n];

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            max = Math.max(max,height[i]);
            prefix[i] = max;
        }

        max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max,height[i]);
            sufix[i] = max;
        }
        max = 0;
        for(int i=0;i<height.length;i++){
            if(height[i]<prefix[i] && height[i]<sufix[i]){
                max+=Math.min(prefix[i],sufix[i])-height[i];
            }
        }
        return max; 
    }
}
