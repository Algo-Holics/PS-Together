package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class Unfinished {
    public static void main(String[] args) {
        System.out.println(new Solution1().solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
        System.out.println(new Solution1().solution(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"}, new String[] {"josipa", "filipa", "marina", "nikola"}));
        System.out.println(new Solution1().solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"}));
    }
}

class Solution1{
    //최근 푼 코드
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        String answer = "";

        for(String p: participant){
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for(String c: completion){
            map.put(c, map.get(c) - 1);
        }

        for(String m: map.keySet()){
            if(map.get(m) != 0){
                answer = m;
                break;
            }
        }

        return answer;
    }

    //예전에 풀었던 코드
    public String solution2(String[] participant, String[] completion) {
        Map <String, Integer> hm = new HashMap<>();

        for(int i = 0; i < participant.length; i++) {
            if (hm.containsKey(participant[i])) {
                hm.put(participant[i], hm.get(participant[i])+1);
            }else {
                hm.put(participant[i], 1);
            }
        }

        // completion 을 돌면서 참가자 이름에 해당하는 value 빼주기
        for (int i = 0; i < completion.length; i++) {
            if(hm.containsKey(completion[i])) {
                hm.put(completion[i], hm.get(completion[i])-1);
            }
        }

        String answer = "";
        for(String key: hm.keySet()) {
            if(hm.get(key) >= 1) {
                answer = key;
            }
        }
        return answer;
    }
}



