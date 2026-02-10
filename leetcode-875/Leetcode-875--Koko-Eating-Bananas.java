class Solution {
    public boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;
        for (int pile : piles) {
            hours += pile / k;
            if (pile % k != 0) hours++;  
        }
        return hours <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int ans = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canFinish(piles, h, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return ans;
    }
}