//  별 찍기 - 9

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i - 1; j++) {
                sb.append(" ");
            }
            for(int j = 0; j < (n-i) * 2 + 1; j++) {
                sb.append("*");
            }
//            별 뒤에 공백 제거
//            for(int j = 0; j < i - 1; j++) {
//                sb.append(" ");
//            }
            sb.append("\n");
        }
        for(int i = n-1; i >= 1; i--) {
            for(int j = 0; j < i - 1; j++) {
                sb.append(" ");
            }
            for(int j = 0; j < (n-i) * 2 + 1; j++) {
                sb.append("*");
            }
//             별 뒤에 공백 제거
//             for(int j = 0; j < i - 1; j++) {
//               sb.append(" ");
//             }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}