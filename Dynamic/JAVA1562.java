package Dynamic;

import java.util.Scanner;

public class JAVA1562{
    public static int N, VISIT = 1 << 10, MOD = 1000000000;
    public static long dp[][][] = new long[101][10][VISIT];
    public static int sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sum = 0;
        for (int i = 1; i < 10; i++) {
            dp[1][i][1 << i] = 1; // 1자리 숫자 0~9값 초기화
        }

        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 1024; k++) { // k = 2^10 (숫자 0~9의 데이터 상태)
                    int bit = k | (1 << j);
                    if (j == 0) {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k]) % MOD;
                    } else if (j == 9) {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j - 1][k]) % MOD;
                    } else {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k] + dp[i - 1][j - 1][k]) % MOD;
                    }
                }
            }

        }
        for( int i = 0 ; i < 10; i++){
            sum = (sum + (int)dp[N][i][VISIT - 1] ) % MOD ;
        }
        System.out.println(sum % MOD);
    }
}