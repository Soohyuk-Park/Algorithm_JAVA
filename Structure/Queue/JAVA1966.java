package Structure.Queue;

import java.util.*;

public class JAVA1966{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_num = sc.nextInt();
        while (test_num-- > 0) {
            LinkedList<int[]> queue = new LinkedList<>();
            int cardinality = sc.nextInt();
            int target = sc.nextInt();
            boolean bool = true;
            ArrayList<int[]> answer = new ArrayList<>();
            for (int i = 0; i < cardinality; i++) {
                int k = sc.nextInt();
                int[] L = new int[]{i, k};
                queue.add(L);
            }
            while (bool) {
                int start = queue.get(0)[1];
                for (int i = 0; i < queue.size(); i++) {
                    if (start < queue.get(i)[1]) {
                        int[] temp = queue.poll();
                        queue.offer(temp);
                        break;
                    } else if (i == queue.size() - 1) {
                        answer.add(queue.poll());
                    }
                }
                bool = !queue.isEmpty();
            }
            for (int i = 0; i < answer.size(); i++) {
                if (answer.get(i)[0] == target) {
                    System.out.println(i + 1);
                    break;
                }
            }

        }
    }
}