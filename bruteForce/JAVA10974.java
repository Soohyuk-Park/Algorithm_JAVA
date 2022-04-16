package bruteForce;

import java.util.Scanner;

public class JAVA10974{

    public static void permutation(int arr[], boolean visited[], int n, int start, int depth){
        arr[depth] = start;

        if (depth == n) {
            for (int i = 1; i <= n; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i] == true)
                continue;
            visited[i] = true;
            permutation(arr, visited, n, i, depth + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n+1];
        boolean visited[] = new boolean[n+1];

        for(int i=1;i<=n;i++){
            visited[i] = true;
            permutation(arr, visited, n, i, 1);
            visited[i] = false;
        }
    }

}