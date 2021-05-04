package programmers.stack;

import java.util.*;

public class Solution4 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Sol4().solution(new int[]{1, 2, 3, 2, 3})));
    }
}

class Sol4 {
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int pivot = prices[i];
            int cnt = 0;
            for(int j = i+1; j < prices.length; j++){
                cnt++;
                if(pivot > prices[j]){
                    break;
                }
            }
            ans[i] = cnt;
        }
        return ans;
    }
}
