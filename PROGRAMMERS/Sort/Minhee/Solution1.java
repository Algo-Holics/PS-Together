package programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Sol1().solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
    }
}

class Sol1 {
    public int[] solution(int[] array, int[][] commands) {
        int[] ret = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            List<Integer> list = new ArrayList<>();
            int start = commands[i][0];
            int end = commands[i][1];
            int findIdx = commands[i][2] - 1;

            for (int j = start - 1; j < end; j++) {
                list.add(array[j]);
            }
            Collections.sort(list);
            ret[i] = list.get(findIdx);
        }

        return ret;
    }
}