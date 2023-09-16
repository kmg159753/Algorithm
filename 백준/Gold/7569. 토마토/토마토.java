
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Tuple {
        int x;
        int y;
        int z;

        public Tuple(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[][][] board = new int[105][105][105];
        int[][][] vis = new int[105][105][105];

        for (int l = 0; l < K; l++) {
            for (int i = 0; i < N; i++) {
                stringTokenizer = new StringTokenizer(bf.readLine());
                for (int j = 0; j < M; j++) {
                    board[i][j][l] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
        }

        Queue<Tuple> q = new LinkedList<>();

        for (int l = 0; l < K; l++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    vis[i][j][l] = -1;

                    if (board[i][j][l] == 1) {
                        q.add(new Tuple(i, j, l));
                        vis[i][j][l] = 0;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Tuple tuple = q.poll();

            for (int dir = 0; dir < 6; dir++) {
                int nx = tuple.x + dx[dir];
                int ny = tuple.y + dy[dir];
                int nz = tuple.z + dz[dir];

                if (nx >= N || nx < 0 || ny >= M || ny < 0 || nz >= K || nz < 0) continue;
                if (board[nx][ny][nz] != 0 || vis[nx][ny][nz] >= 0) continue;
                vis[nx][ny][nz] = vis[tuple.x][tuple.y][tuple.z] + 1;
                q.offer(new Tuple(nx, ny, nz));
            }
        }

        int mx = 0;

        for (int l = 0; l < K; l++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (vis[i][j][l] == -1 && board[i][j][l] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    mx = Math.max(mx, vis[i][j][l]);
                }
            }
        }

        System.out.println(mx);
    }
}
