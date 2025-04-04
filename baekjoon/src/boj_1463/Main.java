package boj_1463;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] d = new int[1000000+1];

        d[1] = 0;
        d[2] = d[3] = 1;
        for (int i = 4; i <= n; i++) {
            d[i] = d[i-1] + 1;

            if (i % 2 == 0) {
                d[i] = Math.min(d[i], d[i/2] + 1);
            }

            if (i % 3 == 0) {
                d[i] = Math.min(d[i], d[i/3] + 1);
            }
        }

        System.out.print(d[n]);
    }
}
