//  별 찍기 - 10

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        boolean answer[][] = new boolean[n+1][n+1];

        solve(answer, 1, 1, n);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if (answer[i][j] == true) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void solve(boolean[][] answer, int startY, int startX, int n) {
        if (n == 1) {
            answer[startY][startX] = true;
            return;
        }

        // 첫 번째 줄
        solve(answer, startY, startX, (n/3));
        solve(answer, startY, startX + (n/3), (n/3));
        solve(answer, startY, startX + (n/3)*2, (n/3));

        // 두 번째 줄
        solve(answer, startY + (n/3), startX, (n/3));
        // 공백
        solve(answer, startY + (n/3), startX + (n/3)*2, (n/3));

        // 세 번째 줄
        solve(answer, startY + (n/3)*2, startX, (n/3));
        solve(answer, startY + (n/3)*2, startX + (n/3), (n/3));
        solve(answer, startY + (n/3)*2, startX + (n/3)*2, (n/3));

        return;
    }
}