import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader n = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(n.readLine());
        String num_input = n.readLine();
        String[] split = num_input.split("");

        int sum = 0;
        for (int i = 0; i < input; i++) {
            sum += Integer.parseInt(split[i]);
        }
        System.out.println(sum);
    }
}
