package programmers.sort;

import java.util.ArrayList;
import java.util.Comparator;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(new Sol2().solution(new int[]{6, 10, 2}));
        System.out.println(new Sol2().solution(new int[]{3, 30, 34, 5, 9}));
        System.out.println(new Sol2().solution(new int[]{0,0,0,0,0}));
    }
}

class Sol2{
    public String solution(int[] numbers){
        String answer = "";
        //1. number -> string
        ArrayList<String> list = new ArrayList<>();
        for(int n: numbers){
            list.add(String.valueOf(n));
        }
        //2. 문자열 비교
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        //3. 반환할 문자열 만들어주고
        StringBuilder sb = new StringBuilder();
        for(String s: list){
            sb.append(s);
        }
        //4. 만약 맨 처음이 0 이면 0, 00, 000, .. 이런 상태일테니 "0"을 반환해주고 그게 아니면 answer 반환        answer = sb.toString();
        if(answer.charAt(0) == '0'){
            answer = "0";
        }

        return answer;
    }
}

/*
문자열 비교 (compareTo)
https://mine-it-record.tistory.com/133
[요약]
1. abcd ab => 포함관계일 경우, 문자열 길이 차이 반환
2. abcd b => 앞에서부터 차례로 아스키코드 값 비교. (a - b = -1)
*/