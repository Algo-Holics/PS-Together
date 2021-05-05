package programmers.sort;

import java.util.Arrays;

public class Solution3 {
    public static void main(String[] args) {
        System.out.println(new Sol3().solution(new int[] {3,0,6,1,5}));
    }
}

class Sol3{
    public int solution(int[] citations){
        Arrays.sort(citations);
        int answer = 0;

        for(int i = 0; i < citations.length; i++){
            int h = Math.min(citations[i], citations.length - i);
            answer = Math.max(answer, h);
        }

        return answer;
    }
}