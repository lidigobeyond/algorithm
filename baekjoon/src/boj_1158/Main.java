package boj_1158;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                queue.add(queue.remove());
            }
            answer.add(queue.remove());
        }

        System.out.print("<" + answer.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + ">");
    }
}
