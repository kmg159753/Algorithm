
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(stringTokenizer.nextToken());
        int width = Integer.parseInt(stringTokenizer.nextToken());

        int[][] board = new int[height][width];
        boolean[][] vis = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int[] dh = {1, 0, -1, 0};
        int[] dw = {0, 1, 0, -1};

        int num = 0;
        int mx = 0;



        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 1 && !vis[i][j]) {
                    Queue<Pair> queue = new LinkedList<>();
                    vis[i][j] = true;
                    queue.offer(new Pair(i, j));

                    int area = 0;

                    while (!queue.isEmpty()) {
                        area++;
                        Pair cur = queue.poll();

                        for (int dir = 0; dir < 4; dir++) {
                            int nh = cur.x + dh[dir];
                            int nw = cur.y + dw[dir];

                            if (nh >= height || nh < 0 || nw >= width || nw < 0) continue;
                            if (board[nh][nw] != 1 || vis[nh][nw]) continue;

                            vis[nh][nw] = true;
                            queue.add(new Pair(nh, nw));

                        }
                    }
                    mx = Math.max(mx, area);
                    num++;
                }
            }
        }

        System.out.println(num);
        System.out.println(mx);
    }
}


