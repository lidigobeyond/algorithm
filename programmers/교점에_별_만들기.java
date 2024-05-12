import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private static class Point {
        public final long x, y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * 직선 a1x + b1y + c1 = 0 과 직선 a2x + b2y + c2 = 0 가 평행한지 확인합니다.
     * @param a1
     * @param b1
     * @param c1
     * @param a2
     * @param b2
     * @param c2
     * @return
     */
    private boolean isParallel(long a1, long b1, long c1, long a2, long b2, long c2) {
        return a1 * b2 == a2 * b1;
    }

    /**
     * 직선 a1x + b1y + c1 = 0 와 직선 a2x + b2y + c2 = 0 의 교점을 반환합니다.
     *
     * @param a1
     * @param b1
     * @param c1
     * @param a2
     * @param b2
     * @param c2
     * @return
     */
    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - c1 * b2) / (a1 * b2 - b1 * a2);
        double y = (double) (c1 * a2 - a1 * c2) / (a1 * b2 - b1 * a2);

        // 정수 교점이 아니면 null 반환
        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }

        return new Point((long)x, (long)y);
    }

    /**
     * 점들의 x 좌표 중 가장 작은 값을 반환합니다.
     * @param points
     * @return
     */
    private long getMinX(List<Point> points) {
        return points.stream().mapToLong(point -> point.x).min().getAsLong();
    }

    /**
     * 점들의 x 좌표 중 가장 큰 값을 반환합니다.
     * @param points
     * @return
     */
    private long getMaxX(List<Point> points) {
        return points.stream().mapToLong(point -> point.x).max().getAsLong();
    }

    /**
     * 점들의 y 좌표 중 가장 작은 값을 반환합니다.
     * @param points
     * @return
     */
    private long getMinY(List<Point> points) {
        return points.stream().mapToLong(point -> point.y).min().getAsLong();
    }

    /**
     * 점들의 y 좌표 중 가장 큰 값을 반환합니다.
     * @param points
     * @return
     */
    private long getMaxY(List<Point> points) {
        return points.stream().mapToLong(point -> point.y).max().getAsLong();
    }

    public String[] solution(int[][] line) {
        // 교점 찾기
        List<Point> intersections = new ArrayList<>();

        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < line.length; j++) {
                if (i == j) {
                    continue;
                }

                // 두 직선이 평행한지 확인
                if (isParallel(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2])) {
                    continue;
                }

                Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);

                if (intersection == null) {
                    continue;
                }

                intersections.add(intersection);
            }
        }

        // 별을 그릴 사각형의 크기 구하기
        long minX = getMinX(intersections);
        long maxX = getMaxX(intersections);
        long minY = getMinY(intersections);
        long maxY = getMaxY(intersections);

        int width = (int)(maxX - minX + 1);
        int height = (int)(maxY - minY + 1);

        // 별을 그릴 사각형 생성
        char[][] canvas = new char[height][width];

        // 별을 그릴 사각형 초기화
        for (char[] row : canvas) {
            Arrays.fill(row, '.');
        }

        // 별 그리기
        for (Point intersection : intersections) {
            int x = (int)(intersection.x - minX);
            int y = (int)(maxY - intersection.y);

            canvas[y][x] = '*';
        }

        // 문자열로 변환
        String[] answer = new String[height];
        for (int i = 0; i < canvas.length; i++) {
            answer[i] = new String(canvas[i]);
        }

        return answer;
    }
}