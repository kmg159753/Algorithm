import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};

        Set<Integer> set = new HashSet<>();

        //0~5
        int sum =0;
        for(int i=0; i<numbers.length-1; i++){//0    1                                 4
            for (int j = i+1; j <numbers.length;  j++) {// 1 2 3 4 5 ,    2 3 4 5       5
                sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }

        answer = new int[set.size()];
        int index=0;

        for (Integer set1 : set) {
            answer[index] = set1;
            index++;
        }

        Arrays.sort(answer);

        return answer;
    }
}