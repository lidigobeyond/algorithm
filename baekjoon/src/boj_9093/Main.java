package boj_9093;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        while(t-- > 0) {
            String str = br.readLine();
            str += '\n';
            for(int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ' || str.charAt(i) == '\n') {
                    while(!stack.empty()) {
                        bw.write(stack.pop());
                    }
                    bw.write(str.charAt(i));
                } else {
                    stack.push(str.charAt(i));
                }
            }

            bw.flush();
        }
        bw.close();
    }
}
