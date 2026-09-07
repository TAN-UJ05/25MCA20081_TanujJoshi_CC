class Solution {
    boolean canPlace(int[] position, int m, int k) {
        int n = position.length;
        int count = 1, prevPlace = position[0];
        for (int i = 1; i < n; i++) {
            if (position[i] - prevPlace >= k) {
                prevPlace = position[i];
                count++;
            }
            if (count >= m)
                return true;
        }
        return false;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int l = 1, h = position[n - 1] - position[0];
        int ans = 0;
        while (l <= h) {
            int k = l + (h - l) / 2;
            if (canPlace(position, m, k)) {
                ans = k;
                l = k + 1;
            } else
                h = k - 1;
        }
        return ans;
    }
}
