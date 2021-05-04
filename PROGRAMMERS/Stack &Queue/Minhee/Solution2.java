package programmers.stack;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(new Sol2().solution(new int[]{2,1,3,2}, 2));
        System.out.println(new Sol2().solution(new int[]{1,1,9,1,1,1}, 0));
    }
}

class Sol2{
    public int solution(int[] priorities, int location) {
        int cnt = 0;
        Queue<P> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            queue.add(new P(i, priorities[i]));
        }
        Arrays.sort(priorities);

        int i = priorities.length-1;
        while(!queue.isEmpty()){
            P p = queue.poll();
            if(p.idx == location && p.priority == priorities[i]){
                cnt++;
                return cnt;
            }else if(p.priority == priorities[i]){
                cnt++;
                i--;
            }else{
                queue.add(p);
            }
        }
        return cnt;
    }
}

class P{
    int idx;
    int priority;

    P(int idx, int priority){
        this.idx = idx;
        this.priority = priority;
    }
}

/* [조건]
 * 1. 우선순위가 같고 위치도 같으면 그게 정답이다.
 * 2. 우선순위만 같고, 위치는 다르다면 출력한다는 의미니까 큐에서 꺼내고(q.poll 다시 안넣음), 최대값 위치를 변경한다(i--), 출력했으니까 cnt ++
 * 3. 나머지 경우엔 출력 불가능하니까 꺼냈던걸 다시 큐에 담아준다.

 * [예전이랑 달라진점]
 * 예전에 풀때는 Collections.sort() 를 내림차로 해서 구현했고
 * 이번에는 Arrays.sort()를 오름차로해서 구현했다.
 * 조건문도 조금 더 복잡하게 썼었던 것 같은데 의미는 크게 다르지 않다.
 *
 * [예전코드 링크]: https://github.com/minhee0327/Algorithm/blob/master/JAVA/Programmers/%EA%B3%A0%EB%93%9D%EC%A0%90kit/stack_queue/%ED%94%84%EB%A6%B0%ED%84%B0.java
 * */

