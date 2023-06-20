import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;


        int max_left =0;
        int max_right =0;
        for(int i =0;i < sizes.length;i++){ //[60, 50] , [30, 70]
            if(sizes[i][0] < sizes[i][1]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;//
            }

            if(max_left < sizes[i][0]){
                max_left = sizes[i][0];
            }
            if(max_right < sizes[i][1]){
                max_right = sizes[i][1];
            }
        }

        answer = max_left * max_right;

        return answer;
    }
}