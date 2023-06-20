import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int divisor) {
        int[] result_array = Arrays.stream(array).filter(factor -> factor % divisor == 0).sorted().toArray();

        if(result_array.length ==0){
            int[] answer = {-1};
            return answer;
        }

        return result_array;
    }
}