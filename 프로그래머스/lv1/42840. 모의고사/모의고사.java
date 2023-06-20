import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public int[] solution(int[] answers) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] cnt = new int[4]; // cnt[1] => 1 번사람 정담수 갯수 ...


        for(int i=0; i< answers.length; i++){

            if(answers[i] == arr1[i % 5] ){ // 0 1 2 3 4    5 6 7 8 9    10 11 12 13 14  ~~~~  30 ....
                cnt[1]++;
            }

            if(answers[i] == arr2[i % 8] ){
                cnt[2]++;
            }

            if(answers[i] == arr3[i % 10] ){
                cnt[3]++;
            }
        }

        ArrayList<Integer> winner = new ArrayList<>();


        if(cnt[1] >= cnt[2] &&  cnt[1] >= cnt[3]){
            winner.add(1);
        }

        if(cnt[2] >= cnt[1] &&  cnt[2] >= cnt[3]){
            winner.add(2);
        }

        if(cnt[3] >= cnt[2] &&  cnt[3] >= cnt[1]){
            winner.add(3);
        }

        Collections.sort(winner);
        
        int[] result = new int[winner.size()];
        
        for(int i=0; i<winner.size(); i++){
            result[i] = winner.get(i);
        }

        return result;
    }
}