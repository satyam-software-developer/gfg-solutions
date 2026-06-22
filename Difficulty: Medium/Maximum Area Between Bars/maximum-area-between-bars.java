class Solution {
    public int maxArea(List<Integer> height) {
        int left = 0;
        int right = height.size() - 1;
        int ans = 0;

        while (left < right) {
            int h = Math.min(height.get(left), height.get(right));
            ans = Math.max(ans, h * (right - left - 1));

            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }
}