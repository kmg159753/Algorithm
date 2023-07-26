import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        Stack<Integer> stack = new Stack<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(reader.readLine());

            if(num != 0 ){
                stack.push(num);
            }else{
                stack.pop();
            }

        }int sum=0;

        for(int i=0; i<stack.size(); i++){
            sum += stack.get(i);
        }

        System.out.println(sum);

    }

}



