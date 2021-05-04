package programmers.stack;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Sol1().solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
        System.out.println(Arrays.toString(new Sol1().solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
    }
}

class Sol1 {
    //최근 코드 (queue)
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int n = progresses.length;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add((100 - progresses[i]) % speeds[i] == 0 ? (100 - progresses[i]) / speeds[i] : (100 - progresses[i]) / speeds[i] + 1);
        }

        List<Integer> cntList = new ArrayList<>();

        int cnt = 1;
        int prev = 0;

        if(q.isEmpty()){
            return new int[] {0};
        }else{
            prev = q.poll();
        }

        while(!q.isEmpty()){
            if(prev >= q.peek()){
                cnt ++;
                q.poll();
            }else{
                cntList.add(cnt);
                cnt = 1;
                prev = q.poll();
            }
        }
        cntList.add(cnt);

        answer = new int[cntList.size()];
        for(int i = 0; i < cntList.size();i++){
            answer[i] = cntList.get(i);
        }

        return answer;
    }


    //저번에 풀었던 코드(stack)
    public int[] solution2(int[] progresses, int[] speeds) {
        Stack <Integer> stack = new Stack<>();

        for(int i = speeds.length-1 ; i >= 0 ; i--) {
            if((100 - progresses[i])% speeds[i] != 0) {
                progresses[i] = (100 - progresses[i])/speeds[i] + 1;
            }else {
                progresses[i] = (100 - progresses[i]) / speeds[i];
            }
            stack.push(progresses[i]);
        }

        List <Integer> tempCnt = new ArrayList<>();
        while(!stack.isEmpty()) {
            int pivot = stack.pop();
            int cnt = 1;
            while (!stack.isEmpty() && pivot >= stack.peek()) {
                stack.pop();
                cnt ++;
            }
            tempCnt.add(cnt);
        }

        int[] answer = new int[tempCnt.size()];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = tempCnt.get(i);
        }

        return answer;
    }
}
