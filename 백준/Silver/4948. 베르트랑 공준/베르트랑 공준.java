import java.util.*;
public class Main {
    public static void main(String[] args) {

        int m = 123456*2 ;

        boolean[] arr = new boolean[m+1];
        // 소수면 true, 소수 아니면 false

        


        for (int i=2; i*i<=m; i++){
            if (arr[i]) continue;
            for (int j=i*i; j<=m; j+=i)
                arr[j] =true;
        }

        Scanner in = new Scanner(System.in);
        while(true) {
            int n = in.nextInt();
            if(n==0) break;
            int cnt =0;

            for(int i=n+1; i<=2*n; i++){
                if(!arr[i]){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }

        in.close();
    }
}