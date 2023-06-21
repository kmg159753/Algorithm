class Solution {
    public int solution(String s) {
        String[] numArr = {"zero", "one", "two", "three",
                "four", "five", "six", "seven", "eight", "nine"};
        String result = ""; //one4seveneight
        for(int i=0; i<numArr.length; i++){
            s = s.replace(numArr[i], Integer.toString(i));
        }


        return Integer.parseInt(s);
    }
}