package Graph.dijkstra;

import java.util.*;

public class JAVA11779{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<int[]>[] adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++)
            adj[sc.nextInt()].add(new int[]{sc.nextInt(), sc.nextInt()});

        int start = sc.nextInt(), dest = sc.nextInt();

        int[] dist = new int[N + 1];
        int[] prev = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.add(new int[]{start, 0});
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (dist[cur[0]] < cur[1]) continue;
            if (dest == cur[0]) break;

            for (int[] a : adj[cur[0]]) {
                if (dist[a[0]] <= cur[1] + a[1]) continue;

                queue.add(new int[]{a[0], cur[1] + a[1]});
                prev[a[0]] = cur[0];
                dist[a[0]] = cur[1] + a[1];
            }
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int city = dest;

        while (city != 0) {
            stack.push(city);
            city = prev[city];
        }

        System.out.println(dist[dest]);
        System.out.println(stack.size());
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
        System.out.println();

    }
}
