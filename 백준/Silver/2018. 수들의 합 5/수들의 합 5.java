import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bf.readLine());
        int[] arr = new int[number + 5];

        arr[0] = 0;
        for (int i = 1; i <= number; i++) {
            arr[i] = i + arr[i - 1];
        }

        int en = 0;

        int sum = 0;
        for (int st = 0; st <= number; st++) {

            while (en <= number  && arr[en] - arr[st] < number) {
                en++;
            }

            if (arr[en] - arr[st] == number) {
                sum++;             
            }
        }
        System.out.println(sum);
    }
}
