package boj_1406;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        String str = br.readLine();
        for(int i = 0; i <str.length(); i++) {
            left.push(str.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());
        while(n-- != 0) {
            String command = br.readLine();

            if (command.charAt(0) == 'L') {
                if (!left.empty()) {
                    right.push(left.pop());
                }
            } else if (command.charAt(0) == 'D') {
                if (!right.empty()) {
                    left.push(right.pop());
                }
            } else if (command.charAt(0) == 'B') {
                if (!left.empty()) {
                    left.pop();
                }
            } else if (command.charAt(0) == 'P'){
                left.push(command.charAt(2));
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!left.empty()) {
            right.push(left.pop());
        }
        while(!right.empty()) {
            sb.append(right.pop());
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
