import java.util.Arrays;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        answer = new int[2];

        Arrays.sort(lottos); // 0 0 1 25 31 44
        Arrays.sort(win_nums); // 1 6 10 19 31 45
        int same_number_cnt =0; // 최저 등수
        int zero_cnt =0; // 최대 등수 = zero_cnt + same_number_cnt


        for(int i =0; i < lottos.length;i++){ //// 0 0 1 25 31 44
            for (int j = 0; j < win_nums.length; j++) { // 1 6 10 19 31 45   0 0 1 25 31 44
                if(lottos[i] == 0){
                    zero_cnt+=1;
                    break;
                }else if(win_nums[j] == lottos[i]){
                    same_number_cnt+=1;
                    break;

                }
            }
        }


        if(zero_cnt ==6){
            answer[0] = 7- (zero_cnt + same_number_cnt);
            answer[1] = 6;
        }else if(zero_cnt ==0 && same_number_cnt ==0){
            answer[0] = 6;
            answer[1] = 6;
        }
        else{
            answer[0] = 7- (zero_cnt + same_number_cnt);
            answer[1] = 7 - same_number_cnt;
        }
        return answer;
    }
}