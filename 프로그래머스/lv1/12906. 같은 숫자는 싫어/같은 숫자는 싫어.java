import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
       int[] answer = {};

        Stack<Integer> st = new Stack<>();

        for(int i=arr.length-1 ; i>=0; i--){
            if(st.size()!=0){
                if(st.peek() != arr[i])  st.push(arr[i]);
            }else{
                st.push(arr[i]);
            }
        }        

        answer = new int[st.size()];
        

        int index =0 ;
        while(!st.empty()){
            answer[index] = st.pop();
            index++;
            
        }       

        return answer;
    }
}