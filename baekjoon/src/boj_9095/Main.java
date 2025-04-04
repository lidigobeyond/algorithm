package boj_9095;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int[] d = new int[10 + 1];

            d[0] = 1;
            for (int i = 1; i <= n; i++) {
                d[i] = d[i-1];

                if (i - 2 >= 0) {
                    d[i] += d[i - 2];
                }

                if (i - 3 >= 0) {
                    d[i] += d[i - 3];
                }
            }

            System.out.println(d[n]);
        }
    }
}
