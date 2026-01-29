//  일곱 난쟁이

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int n = 9;

        int[] heights = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
            sum += heights[i];
        }

        Arrays.sort(heights);
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if ((sum - heights[i] - heights[j]) == 100) {
                    for(int k = 0; k < 9; k++) {
                        if (k == i || k == j) {
                            continue;
                        }
                        System.out.println(heights[k]);
                    }
                    return;
                }
            }
        }
    }
}