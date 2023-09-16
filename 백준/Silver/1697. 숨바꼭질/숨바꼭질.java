import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
        int subin = Integer.parseInt(stringTokenizer.nextToken());
        int sister = Integer.parseInt(stringTokenizer.nextToken());

        

        int[] vis = new int[100005];

        for (int i = 0; i < 100001; i++) {
            vis[i] = -1;
        }
        vis[subin] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(subin);

        while (vis[sister] == -1) {
            int cur = q.poll();

            for (int nx : new int[]{cur - 1, 2 * cur, cur + 1}) {
                if (nx < 0 || nx > 100000) continue;
                if (vis[nx] != -1) continue;
                vis[nx] = vis[cur] + 1;
                q.offer(nx);
            }
        }
        System.out.println(vis[sister]);
    }
}