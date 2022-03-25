package Dynamic;

import java.util.Scanner;

public class JAVA2133 {
    static int n;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n+2];

        System.out.println(d(n));
    }
    public static int d( int n ){
        if( n == 0) return 1;
        if( n == 1) return 0;
        if( n == 2) return 3;
        if(dp[n] != 0) return dp[n];
        int result = 3 * d(n-2);
        for( int i = 3; i<=n;i++){
            if( i % 2 == 0) result += 2*d(n-i);
        }
        return dp[n] = result;
    }
}
