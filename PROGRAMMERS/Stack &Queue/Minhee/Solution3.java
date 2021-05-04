package programmers.stack;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    public static void main(String[] args) {
        System.out.println(new Sol3().solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(new Sol3().solution(100, 100, new int[]{10}));
        System.out.println(new Sol3().solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }
}

class Sol3 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int totalTime = 0;              //총 걸린 시간
        int currentTotalWeight = 0;     //다리위에 있는 트럭들 총합
        int exit = 0;                   //빠져나온 트럭 수

        //readQ: 대기중인 트럭, runQ: 건너는 중인 트럭
        Queue<Truck> readyQ = new LinkedList<>();
        Queue<Truck> runQ = new LinkedList<>();

        // 대기중인 트럭 Q에 트럭 정보를 담는다.
        for (int t : truck_weights) {
            readyQ.add(new Truck(bridge_length, t));
        }

        // 만약 대기중인 큐와 움직이는 큐 모두 빈 상태가 아니면 계속 프로세스를 진행시킨다.
        while (exit < truck_weights.length) {

            //달리고 있는 트럭이 있으면 1초씩 줄여줌.
            for (Truck t : runQ) {
                t.time--;
            }


            for (int i = 0; i < runQ.size(); i++) {
                Truck t = runQ.poll();
                // 만약 다리 길이만큼 갔으면 빠져나온 트럭수를 증가시켜주고, 다리 위의 트럭 무게 총합은줄여준다.
                if (t.time == 0) {
                    exit++;
                    currentTotalWeight -= t.weight;
                }
                // 아직 다리 길이만큼 못갔으면 다시 달리는 큐에 넣어준다.
                else {
                    runQ.add(new Truck(t.time, t.weight));
                }
            }

            //매 초를 카운트
            totalTime++;

            // 만약 레디큐가 비었으면 더이상 런큐에 담을 필요 없으니 통과하고
            if (readyQ.isEmpty()) {
                continue;
            // 레디큐에 트럭이 있는데, 런큐가 비었거나
            // 다음에 트럭이 들어왔을 때 무게가 무게제한에 걸리지 않고, 트럭 차의 개수가 다리 길이보다 작으면 트럭을 하나 더 런큐에 담아준다.
            } else if (runQ.isEmpty() || (currentTotalWeight + readyQ.peek().weight <= weight && runQ.size() < bridge_length)) {
                runQ.add(readyQ.peek());
                currentTotalWeight += readyQ.poll().weight;
            }

        }

        return totalTime;
    }
}

// 트럭 클래스는 다리를 건너기 위해 필요한 시간, 트럭의 무게 정보를 가지고 있다.
class Truck {
    int time;
    int weight;

    Truck(int time, int weight) {
        this.time = time;
        this.weight = weight;
    }
}