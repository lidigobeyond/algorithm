package boj_6588;

import java.util.Scanner;

public class Main {
    public static boolean[] check = new boolean[1000001];
    public static void makeEratosthenesSieve() {
        check[0] = check[1] = true;
        for (int i = 2; i <= 1000000; i++) {
            if (check[i]) {
                continue;
            }
            for (int j = i + i; j <= 1000000; j += i) {
                check[j] = true;
            }
        }
    }

    public static boolean isPrime(int n) {
        return !check[n];
    }

    public static void main(String[] args) {
        makeEratosthenesSieve();

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            int n = sc.nextInt();

            for (int a = 0; a < n; a++) {
                if (!isPrime(a) || !isPrime(n - a)) {
                    continue;
                }

                System.out.println(n + " = " + a + " + " + (n - a));
                break;
            }
        }
    }
}
