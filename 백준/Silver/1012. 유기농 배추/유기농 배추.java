import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int T, N, M, K;


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        Queue<Pair> q = new LinkedList<>();

        StringBuilder stringBuilder = new StringBuilder();

        for (int s = 0; s < T; s++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());

            M = Integer.parseInt(stringTokenizer.nextToken());
            N = Integer.parseInt(stringTokenizer.nextToken());
            K = Integer.parseInt(stringTokenizer.nextToken());

            int[][] board = new int[N][M];
            boolean[][] vis = new boolean[N][M];

            for (int j = 0; j < K; j++) {

                stringTokenizer = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(stringTokenizer.nextToken());
                int y = Integer.parseInt(stringTokenizer.nextToken());
                board[y][x] = 1;
            }

            int res = 0; // 출력할 답 

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    if (board[i][j] == 1 && !vis[i][j]) {
                        q.offer(new Pair(j, i));
                        vis[i][j] = true;

                        while (!q.isEmpty()) {
                            Pair pair = q.poll();


                            for (int dir = 0; dir < 4; dir++) {
                                int nx = pair.x + dx[dir];
                                int ny = pair.y + dy[dir];

                                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                                if (vis[ny][nx] || board[ny][nx] != 1) continue;
                                vis[ny][nx] = true;
                                q.offer(new Pair(nx, ny));
                            }
                        }
                        res++;
                    }
                }
            }
            stringBuilder.append(res);
            stringBuilder.append("\n");          
        }
        System.out.println(stringBuilder.toString());
    }
}
