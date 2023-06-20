import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] W = new int[105];
        int[] V = new int[105];

        int[][] DP = new int[105][100005];

        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt(); // 경우의 수
        int K = sc.nextInt(); // 최대 무게

        for(int i=1; i<=N; i++){

            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }

        for(int i=1; i<=N; i++) { // i가 뽑는수
            for(int j=1; j<=K; j++){ // 가방 무게
                if(j-W[i] >=0) DP[i][j] = Math.max(DP[i-1][j], DP[i-1][j-W[i]] +V[i] );
                else  DP[i][j] =  DP[i-1][j];
            }
        }
        System.out.println(DP[N][K]);        
    }

}