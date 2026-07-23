import java.io.*;
import java.util.*;

class Whale {
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    
    static int[][] nextDir = {
        {},
        {1, 3, 4, 2},
        {2, 4, 3, 1},
        {3, 2, 1, 4},
        {4, 1, 2, 3}
    };
    
    static int[] movePriority = {3, 2, 4, 1};

    int x;
    int y;
    int direction;
    int cnt;
    int[][] board;
    boolean[][] visited;

    Whale(int x, int y, int direction, int[][] board, boolean[][] visited) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.board = board;
        this.visited = visited;
        this.cnt = 1;
    }

    public int[] explore() {
        for (int i = 0; i < 4; i++) {
            int nd = nextDir[direction][i];
            int nx = x + dx[nd];
            int ny = y + dy[nd];

            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board.length) {
                if (board[nx][ny] == 0 && !visited[nx][ny]) {
                    x = nx;
                    y = ny;
                    direction = nd;
                    visited[x][y] = true;
                    cnt++;
                    return new int[]{x, y};
                }
            }
        }
        return null;
    }

    public int[] move() {
        int[] target = findNearestTarget();

        if (target == null) {
            return null;
        }

        int lastDir = findLastDirection(target);

        x = target[0];
        y = target[1];
        direction = lastDir;
        visited[x][y] = true;
        cnt++;

        return new int[]{x, y};
    }

    public int[] findNearestTarget() {
        int N = board.length;
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], -1);
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        dist[x][y] = 0;
        
        int minTargetDist = Integer.MAX_VALUE;
        List<int[]> candidates = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];
            
            if (dist[cx][cy] > minTargetDist) {
                break;
            }
            
            if (board[cx][cy] == 0 && !visited[cx][cy]) {
                minTargetDist = dist[cx][cy];
                candidates.add(new int[]{cx, cy});
            }
            
            for (int i = 1; i <= 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (board[nx][ny] == 0 && dist[nx][ny] == -1) {
                        dist[nx][ny] = dist[cx][cy] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        
        if (candidates.isEmpty()) {
            return null;
        }
        
        candidates.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        
        return candidates.get(0);
    }

    public int findLastDirection(int[] target) {
        int N = board.length;
        int tx = target[0];
        int ty = target[1];

        int[][] distToTarget = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(distToTarget[i], -1);
        
        Queue<int[]> tq = new ArrayDeque<>();
        tq.offer(new int[]{tx, ty});
        distToTarget[tx][ty] = 0;
        
        while (!tq.isEmpty()) {
            int[] curr = tq.poll();
            int cx = curr[0];
            int cy = curr[1];
            
            for (int i = 1; i <= 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (board[nx][ny] == 0 && distToTarget[nx][ny] == -1) {
                        distToTarget[nx][ny] = distToTarget[cx][cy] + 1;
                        tq.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        
        int cx = x;
        int cy = y;
        int lastDir = direction;
        
        while (cx != tx || cy != ty) {
            for (int d : movePriority) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (board[nx][ny] == 0 && distToTarget[nx][ny] == distToTarget[cx][cy] - 1) {
                        cx = nx;
                        cy = ny;
                        lastDir = d;
                        break;
                    }
                }
            }
        }
        
        return lastDir;
    }
}

public class CT2 {
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        visited = new boolean[N][N];
        visited[r - 1][c - 1] = true;

        int sea = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 0) {
                    sea++;
                }
            }
        }

        Whale whale = new Whale(r - 1, c - 1, d, board, visited);
        sb.append(r).append(" ").append(c).append("\n");

        while (whale.cnt < sea) {
            int[] next = whale.explore();

            if (next == null) {
                next = whale.move();
                if(next == null) break;
            }

            sb.append(next[0] + 1).append(" ").append(next[1] + 1).append("\n");
        }
        
        System.out.print(sb);
    }
}
