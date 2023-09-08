import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        String num = bf.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(num);
        ArrayList<Integer> num_list = new ArrayList<>();
        num_list.add(0);

        for (int i = 1; i <= n; i++) {
            num_list.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int en = 1;
        int cnt = 0;
        for (int st = 1; st < n; st++) {
            en = st+1;
            while (en < n && num_list.get(en) + num_list.get(st) != m) {
                en++;
            }
            if (num_list.get(en) + num_list.get(st) == m) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }

}
