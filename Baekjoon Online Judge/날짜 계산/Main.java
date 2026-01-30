//  날짜 계산

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int answer = 1;

        int i = 1, j = 1, k = 1;
        while(true) {
            if (i == E && j == S && k == M) {
                break;
            }

            i = (i % 15) + 1;
            j = (j % 28) + 1;
            k = (k % 19) + 1;

            answer++;
        }

        System.out.println(answer);
    }
}