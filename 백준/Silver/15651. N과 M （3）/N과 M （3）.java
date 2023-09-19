import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] vis;
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter((System.out)));


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[10];
        vis = new boolean[10];
        DFS(0, N, M);
        bufferedWriter.flush();
    }

    public static void DFS(int k, int N, int M) throws IOException {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                bufferedWriter.write(Integer.toString(arr[i]) + " ");

            }
            bufferedWriter.newLine();
            
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[k] = i;
            vis[i] = true;
            DFS(k + 1, N, M);
            vis[i] = false;

        }
    }
}
