import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        String number = bf.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(number);
        ArrayList<Integer> numList = new ArrayList<>();

        int num = Integer.parseInt(n);

        for(int i = 0; i< Integer.parseInt(n); i++){
            numList.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        double avg = 0;
        int max = 0;

        for(int i=0; i<numList.size();i++){
            max = Math.max(max, numList.get(i));
        }


        for(int i=0; i<numList.size();i++){
            avg += (double) numList.get(i) / max * 100;
        }


        avg /= numList.size();

        System.out.println(avg);

    }
}
