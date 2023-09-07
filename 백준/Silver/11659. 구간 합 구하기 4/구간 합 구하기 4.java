import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String nm = bf.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(nm);
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        String num_arr = bf.readLine();

        String[] split = num_arr.split(" ");

        ArrayList<Integer> sum_info_list = new ArrayList<>();

        int info_sum = 0;
        sum_info_list.add(0);

        for(int i=0; i<split.length;i++){
            int number = Integer.parseInt(split[i]);
            sum_info_list.add(number + info_sum);
            info_sum += number;
//            System.out.println("sum_info_list"+i +": " + sum_info_list.get(i) );
        }

        while (m>0){
            m--;
            String pair = bf.readLine();
            StringTokenizer st = new StringTokenizer(pair);
            int start = Integer.parseInt(st.nextToken());

            int end = Integer.parseInt(st.nextToken());

            if(start == 1){
                System.out.println(sum_info_list.get(end) );
                continue;
            }

            System.out.println(sum_info_list.get(end) - sum_info_list.get(start-1));
        }

    }
}
