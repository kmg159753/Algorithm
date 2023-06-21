import java.util.Arrays;
class Solution {
    public String[] solution(String[] strings, int n) {
         String[] answer = {};

        answer = new String[strings.length];

        // comparator를 람다식으로 구현, n번쨰 원소기준으로 오름차순으로 정렬
        
        Arrays.sort(strings);
        
        Arrays.sort(strings, (o1, o2) -> o1.charAt(n) - o2.charAt(n) );
        

        for(int i=0; i<strings.length; i++){
            answer[i] = strings[i];
        }


        return answer;
    }
}