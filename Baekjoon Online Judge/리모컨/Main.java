//  리모컨

import java.util.*;
import java.lang.*;

class Main {
    static boolean[] broken = new boolean[10];

    /**
     * 리모콘으로 누를 수 있는 숫자인지 체크
     * @param num
     * @return
     */
    public static boolean isPossible(int num) {
        if (num == 0 && broken[0]) {
            return false;
        }

        while(num > 0) {
            if (broken[num % 10]) {
                return false;
            }
            num /= 10;
        }

        return true;
    }

    /**
     * 숫자 길이를 계산해서 반환
     * @param num
     * @return
     */
    public static int getLength(int num) {
        int length = 0;
        do {
            num /= 10;
            length++;
        } while(num > 0);

        return length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            int num = sc.nextInt();
            broken[num] = true;
        }

        // 숫자 버튼이 모두 고장났을 때 눌러야 하는 횟수로 정답 초기화
        int answer = Math.abs(n - 100);

        // 0번 채널 부터 1000000번 채널까지 숫자 버튼을 눌러서 채널을 이동했을 때 N번 채널로 가는데 눌러야 하는 횟수 전부 계산
        for (int num = 0; num < 1000000; num++) {
            if (!isPossible(num)) {
                continue;
            }

            int length = getLength(num);

            int press = Math.abs(n - num) + length;
            if (press < answer) {
                answer = press;
            }
        }

        System.out.println(answer);
    }
}