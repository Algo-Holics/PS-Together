package programmers.hash;

import java.util.Arrays;

public class Sol2 {
    public static void main(String[] args) {
        System.out.println(new Solution2().solution(new String[] { "119", "97674223", "1195524421" }));
        System.out.println(new Solution2().solution(new String[] { "123", "456", "789" }));
        System.out.println(new Solution2().solution(new String[] { "12", "123", "1235", "567", "88" }));
    }
}

class Solution2 {
    public boolean solution(String[] phone_book) {
        //문자열 정렬을 했기 때문에 119, 1195524421, 976~~ 순이므로 2중 for 문을 돌리지 않고 앞뒤만 비교해도 됨.
        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }

        return true;
    }
}