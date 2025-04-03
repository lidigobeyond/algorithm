package boj_1978;

import java.util.*;

public class Main {
    public static boolean isPrimeNum(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int answer = 0;
       while (n-- > 0){
            if (isPrimeNum(sc.nextInt())) {
                answer++;
            }
        }

        System.out.print(answer);
    }
}
