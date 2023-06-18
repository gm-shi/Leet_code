import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        int result = 1;
        int cur = points[0][1];
        for (int[] point : points) {
            cur = Math.min(cur, point[1]);
            if (cur >= point[0])
                continue;
            else {
                cur = point[1];
                result++;
            }
        }
        return result;
    }
}