//  사탕 게임

import java.util.*;
import java.lang.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            String line = sc.next();
            for(int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int answer = 0;
        for(int y = 0; y < n; y++) {
            for(int x = 0; x < (n - 1); x++) {
                swap(board, y, x, y, x + 1);

                answer = Math.max(answer, check(board, n));

                swap(board, y, x, y, x + 1);
            }
        }

        for(int x = 0; x < n; x++) {
            for(int y = 0; y < (n - 1); y++) {
                swap(board, y, x, y + 1, x);

                answer = Math.max(answer, check(board, n));

                swap(board, y, x, y + 1, x);
            }
        }

        System.out.println(answer);
    }

    /**
     * 보드에 (y1,x1) 좌표의 사탕과 (y2,x2) 좌표의 사탕의 위치를 바꿉니다.
     * @param board
     * @param y1
     * @param x1
     * @param y2
     * @param x2
     */
    public static void swap(char[][] board, int y1, int x1, int y2, int x2) {
        char temp = board[y1][x1];
        board[y1][x1] = board[y2][x2];
        board[y2][x2] = temp;
    }

    /**
     * 보드에서 같은 색으로 이뤄져있는 가장 긴 연속된 부분(행 또는 열)의 길이를 반환합니다.
     * @param board
     * @param n
     * @return
     */
    public static int check(char[][] board, int n) {
        int max = 0;
        for(int y = 0; y < n; y++) {
            int count = 1;
            for(int x = 0; x < (n - 1); x++) {
                if (board[y][x] == board[y][x + 1]) {
                    count += 1;
                } else {
                    count = 1;
                }

                max = Math.max(max, count);
            }
        }

        for(int x = 0; x < n; x++) {
            int count = 1;
            for(int y = 0; y < (n - 1); y++) {
                if (board[y][x] == board[y + 1][x]) {
                    count += 1;
                } else {
                    count = 1;
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }
}