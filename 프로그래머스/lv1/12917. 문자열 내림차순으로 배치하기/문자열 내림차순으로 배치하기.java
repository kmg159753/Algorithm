import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(String s) {
        
        String[] strings = s.split("");

        Arrays.sort(strings, Comparator.reverseOrder());

        StringBuilder stringBuilder = new StringBuilder();
        
        for(int i=0; i<strings.length ; i++){
            stringBuilder.append(strings[i]);
        }
        return stringBuilder.toString();
    }
}