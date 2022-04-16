package bruteForce;

import java.util.Scanner;
import java.util.StringTokenizer;

public class JAVA1182 {
    static int N;
    static int target;
    static int cnt;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        target = sc.nextInt();
        arr = new int[N];
        sc.nextLine();
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        cnt = 0;
        comb(0, 0);
        if( target == 0 ) System.out.println(cnt-1);
        else System.out.println(cnt);
    }

    public static void comb( int sum, int depth) {
        if (depth == N) {
            if(sum == target){
                cnt++;
                return;
            } else return;
        } else {
            comb(sum, depth + 1);
            comb(sum + arr[depth], depth + 1);
        }
    }
}
