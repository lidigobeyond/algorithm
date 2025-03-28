package boj_1874;

import java.util.*;

public class Main {
    public static void solve(int[] a) {
        int m = 0;

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int x: a) {
            if (x > m) {
                while (x > m) {
                    stack.push(++m);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if (stack.peek() != x) {
                    System.out.print("NO");
                    return;
                }
                stack.pop();
                sb.append("-\n");
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        solve(a);
    }
}
