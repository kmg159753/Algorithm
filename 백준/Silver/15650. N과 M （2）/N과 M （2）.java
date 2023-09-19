import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] vis;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[10];
        vis = new boolean[10];
        DFS(0,N,M);

    }

    public static void DFS(int k, int N, int M) {
        if (k == M) {
            for (int i = 1; i <= M; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {

            if(!vis[i] && arr[k] < i){
                arr[k+1] = i;
                vis[i] = true;
                DFS(k+1 , N , M);
                vis[i] = false;
            }
        }
    }
}
