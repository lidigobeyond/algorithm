package boj_17413;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Character> stack = new Stack<>();

        boolean isTag = false;
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                isTag = true;
                while (!stack.empty()) {
                    System.out.print(stack.pop());
                }
                System.out.print(s.charAt(i));
            }  else if (s.charAt(i) == '>') {
                isTag = false;
                System.out.print(s.charAt(i));
            } else if (isTag) {
                System.out.print(s.charAt(i));
            } else {
                if (s.charAt(i) == ' ') {
                    while(!stack.empty()) {
                        System.out.print(stack.pop());
                    }
                    System.out.print(s.charAt(i));
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }

        while (!stack.empty()) {
            System.out.print(stack.pop());
        }
    }
}
