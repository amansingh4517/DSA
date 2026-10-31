import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int i;
    int j;
}

public class test {
    public static void main(String arg[]) {


        // 0 = rotten and 1 = fresh
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        boolean rotten = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (arr[i][j] == 0)
                    q.push(new Pair(i, j));
                if (arr[i][j] == 0)
                    rotten = true;
            }
        }

        if (!rotten) {
            System.out.println(0);
            return;
        }

        int count = 0;

        while (!q.isEmpty()) {

            count++;
            int len = q.size();
            int[][] dir = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

            for (int i = 0; i < len; i++) {

                Pair front = q.remove();
                int i = front.i, j = front.j;

                for (int[] d : dir) {
                    int x = i + d[0];
                    int y = j + d[1];

                    if (!visited[x][y] && x > 0 && x < n && y > 0 && y < n && arr[x][y]==1){
                        arr[x][y] = 0;
                        q.add(new Pair(x, y));}

                    visited[i][j] = false;
                }
            }

        }
        System.out.println(count);
        return;
    }
}
