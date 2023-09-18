import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Pair {
        int broken;
        int h;
        int w;

        public Pair(int broken, int h, int w) {
            this.broken = broken;
            this.h = h;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(stringTokenizer.nextToken());
        int width = Integer.parseInt(stringTokenizer.nextToken());

        int[][] board = new int[height][width];
        int[][][] dist = new int[2][height][width];

        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                board[i][j] = line.charAt(j) - '0';  // char를 int로 변환
                dist[0][i][j] = dist[1][i][j] = -1;
            }
        }

        int[] dh = {1, 0, -1, 0};
        int[] dw = {0, 1, 0, -1};

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0, 0));
        dist[0][0][0] = dist[1][0][0] = 1; // 0=> 벽 안부숨 , 1 => 벽 부숨


        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nh = cur.h + dh[dir];
                int nw = cur.w + dw[dir];

                if (nh >= height || nh < 0 || nw >= width || nw < 0) continue;
                if (board[nh][nw] == 0 && dist[cur.broken][nh][nw] == -1){
                    dist[cur.broken][nh][nw] = dist[cur.broken][cur.h][cur.w] + 1;
                    q.offer(new Pair(cur.broken, nh, nw));
                }

                if(cur.broken == 0 && board[nh][nw] == 1 && dist[cur.broken][nh][nw] == -1 ){
                    dist[1][nh][nw] = dist[cur.broken][cur.h][cur.w] + 1;
                    q.offer(new Pair(1,nh, nw));
                }
            }
        }

        if(dist[0][height-1][width-1] == -1 && dist[1][height-1][width-1] == -1){
            System.out.println(-1);
            return;
        }

        
        if(dist[0][height - 1][width - 1]!= -1 && dist[1][height - 1][width - 1] == -1){
            System.out.println(dist[0][height - 1][width - 1]);
            
        } else if (dist[0][height - 1][width - 1]== -1 && dist[1][height - 1][width - 1] != -1) {
            System.out.println(dist[1][height - 1][width - 1]);
            
        } else {
            System.out.println(Math.min(dist[0][height - 1][width - 1],dist[1][height - 1][width - 1]));
        }


    }
}