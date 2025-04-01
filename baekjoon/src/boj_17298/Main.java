package boj_17298;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] NGE = new int[n];

        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(temp[i]);
        }

        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        for (int i = 1; i < n; i++) {
            while(!stack.empty() && A[stack.peek()] < A[i]) {
                NGE[stack.pop()] = A[i];
            }

            stack.push(i);
        }

        while(!stack.empty()) {
            NGE[stack.pop()] = -1;
        }

        for (int i = 0; i < n; i++) {
            bw.write(NGE[i] + " ");
        }

        bw.write("\n");
        bw.flush();
    }
}
