import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        int[] arr = new int[100005];
        int N;

        Stack<Integer> st = new Stack<>();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bf.readLine());

        int num = 1;

        for (int i = 0; i < N; i++) {
            arr[num] = Integer.parseInt(bf.readLine());
            num++;
        }
        int index = 1;

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= N; i++) {

            if (i <= arr[index]) {
                st.push(i);
                stringBuilder.append("+");

            }

            while (true) {
                if (st.peek() == arr[index]) {

                    st.pop();
                    stringBuilder.append("-");
                    index++;
                    if(st.isEmpty()){
                        break;
                    }
                }else {
                    break;
                }
            }
        }

        if(!st.isEmpty()){
            bw.write("NO"+"\n" );
        }else{
            String str = stringBuilder.toString();

            for(int i=0; i<str.length(); i++){
                bw.write(str.charAt(i)+"\n");
            }
        }
        bw.flush();   //남아있는 데이터를 모두 출력시킴
        bw.close();   //스트림을 닫음
    }
}