import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private final int[] dirX = {0, 1, -1};
    private final int[] dirY = {1, 0, -1};

    public int[] solution(int n) {
        // n x n 배열을 생성
        int[][] arr = new int[n][n];

        int dir = 0;
        int x = 0, y = 0;

        // 달팽이 배열 생성
        int num = 1;
        while(true) {
            arr[y][x] = num++;

            int nextX = x + dirX[dir];
            int nextY = y + dirY[dir];

            // 다음 위치가 범위를 벗어나거나 이미 값이 채워져있으면 방향을 바꿈
            if (nextX >= n || nextX < 0 || nextY >= n || nextY < 0 || arr[nextY][nextX] != 0) {
                dir = (dir + 1) % 3;

                nextX = x + dirX[dir];
                nextY = y + dirY[dir];

                // 방향을 바꿨는데도 범위를 벗어나거나 이미 값이 채워져있으면 종료
                if (nextX >= n || nextX < 0 || nextY >= n || nextY < 0 || arr[nextY][nextX] != 0) {
                    break;
                }
            }

            x = nextX;
            y = nextY;
        }

        // 결과 반환
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }

                answer.add(arr[i][j]);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}