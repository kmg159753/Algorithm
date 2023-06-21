class Solution {
    public String solution(String s, int n) {
        String answer = "";

        for(int i=0; i<s.length(); i++){
            int x = (int) s.charAt(i);

            if(65 <=x && x<= 90) x = ( (x - 65) + n)%26 + 65; // x= 89   (89 -65 + n ) % 26

            else if(97 <=x && x<= 122) x = ( (x - 97) + n)%26 + 97; // x= 89   (89 -65 + n ) % 26

            answer += (char) x;
        }
        return answer;
    }
}