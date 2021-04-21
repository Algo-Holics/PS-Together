package programmers.hash;

import java.util.*;

public class Sol4 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution4().solution(new String[] { "classic", "pop", "classic", "classic", "pop" },
                new int[] { 500, 600, 150, 800, 2500 })));
        System.out.println(Arrays.toString(new Solution4().solution(new String[] { "classic", "pop", "classic", "classic", "pop" },
                new int[] { 500, 600, 501, 800, 900 })));
    }
}

class Solution4 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalCnt = new HashMap<>();
        List<Song> songList = new ArrayList<>();
        List<Integer> bestAlbum = new ArrayList<>();
        Map<String, Integer> twoCnt = new HashMap<>();

        for(int i = 0; i < genres.length; i++){
            //장르별 총 합계를 map 에 담는다.
            totalCnt.put(genres[i], totalCnt.getOrDefault(genres[i], 0) + plays[i]);
            //음악리스트를 담되 모든 정보 (위치, 장르명, 재생횟수)를 담는다.
            songList.add(new Song(i, genres[i], plays[i]));
        }

        //정렬을하는데 기준
        Collections.sort(songList, new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                //장르가 다른 경우 장르별 총합 비교해서 정렬
                if(!o1.genre.equals(o2.genre)){
                    return Integer.compare(totalCnt.get(o2.genre), totalCnt.get(o1.genre));
                //장르가 같으 song 객체 compare 기준에 따라 정렬
                }else{
                    return o1.compareTo(o2);
                }
            }
        });

        //베스트엘범은 장르별로 최대 2곡까지만 수록
        for(Song s: songList){
            twoCnt.put(s.genre, twoCnt.getOrDefault(s.genre, 0) + 1);

            if(twoCnt.get(s.genre) <= 2){
                bestAlbum.add(s.idx);
            }
        }

        //반환은 int[] 로
        int[] answer= new int[bestAlbum.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = bestAlbum.get(i);
        }
        return answer;
    }

}

class Song implements Comparable<Song>{
    int idx;    //위치
    String genre;  //장르 명
    int play;   //재생 횟수

    Song(int idx, String genre, int play){
        this.idx = idx;
        this.genre = genre;
        this.play = play;
    }

    @Override
    public int compareTo(Song o) {
        //재생 횟수가 같으면 idx를 오름차로 비교하고 아니면 재생횟수 내림차로 비교한다.
        if(this.play == o.play){
            return Integer.compare(this.idx, o.idx);
        }else{
            return Integer.compare(o.play, this.play);
        }
    }
}