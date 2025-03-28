package boj_9012;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        Stack<Character> stack = new Stack<>();
        while(t-- != 0) {
            String str = br.readLine();

            for(int i = 0; i < str.length(); i++) {
                if (stack.empty()) {
                    stack.push(str.charAt(i));
                    continue;
                }

                if (str.charAt(i) == '(') {
                    stack.push('(');
                    continue;
                }

                if (stack.peek() == ')') {
                    stack.pop();
                    continue;
                }

                break;
            }

            if (stack.empty()) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }

            while(!stack.empty()) {
                stack.pop();
            }
        }

        bw.flush();
    }
}
