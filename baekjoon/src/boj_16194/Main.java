package boj_16194;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] p = new int[n+1];
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        int[] d = new int[n+1];
        Arrays.fill(d, 1, n+1, 1000 * 10000);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                d[i] = Math.min(d[i], d[i-j] + p[j]);
            }
        }

        System.out.println(d[n]);
    }
}
