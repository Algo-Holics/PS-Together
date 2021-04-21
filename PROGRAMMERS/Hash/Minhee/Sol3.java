package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class Sol3 {
    public static void main(String[] args) {
        System.out.println(new Solution3().solution(new String[][] { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
                { "green_turban", "headgear" } }));
        System.out.println(new Solution3().solution(
                new String[][] { { "crowmask", "face" }, { "bluesunglasses", "face" }, { "smoky_makeup", "face" } }));
    }
}

class Solution3{
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 1;

        for(String[] c: clothes){
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }

        for(String key: map.keySet()){
            answer*= (map.get(key) + 1);
        }

        return answer-1;
    }
}