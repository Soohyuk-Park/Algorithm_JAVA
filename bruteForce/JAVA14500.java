package bruteForce;

import java.util.ArrayList;
        import java.util.Scanner;

public class JAVA14500{
    static ArrayList<int[]> L = new ArrayList<>();
    static boolean[][] ash_map;
    static int row;
    static int col;
    static int answer = 0;
    static int temp = 0;
    static int[][] map = new int[row][col];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] map = new int[row][col];
        L.add(new int[]{-1, 0});
        L.add(new int[]{0, 1});
        L.add(new int[]{1, 0});
        L.add(new int[]{0, -1});
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        ash_map = new boolean[row][col];
        for( int i = 0; i<row;i++){
            for( int j =0;j<col;j++){
                ash_map[i][j] = true;
                ash(i,j,0, map, 0, ash_map, row, col);
                ash_map[i][j] = false;
                answer = Math.max( hubo(i,j,map,row,col),answer );
            }
        }
        System.out.println(answer);
    }

    public static void ash( int a , int b, int cnt, int map[][], int temp, boolean[][] ash_map, int row, int col){
        ash_map[a][b] = true;
        temp += map[a][b];
        cnt+=1;
        if( cnt == 4 ){
            answer = Math.max( temp, answer);
            ash_map[a][b] = false;
            return;
        }
        for( int i = 0 ; i < 4; i++){
            int x_n = a + L.get(i)[0];
            int y_n = b + L.get(i)[1];
            if( 0<= x_n && x_n < row && 0<= y_n && y_n < col){
                if( ash_map[x_n][y_n] == false ) {
                    ash_map[x_n][y_n] = true;
                    ash(x_n, y_n, cnt, map, temp, ash_map, row, col);
                    ash_map[x_n][y_n] = false;
                }
            }

        }
    }

    public static int hubo( int a , int b, int map[][], int row, int col){
        int here_ans = 0;
        if( 0 < b && b < col -1){
            if( 0<a) here_ans = Math.max( here_ans , map[a][b] + map[a][b-1]+map[a][b+1] + map[a-1][b]);
            if( a<row-1) here_ans = Math.max( here_ans , map[a][b] + map[a][b-1]+map[a][b+1] + map[a+1][b]);
        }
        if( 0 < a && a < row -1){
            if( 0<b) here_ans = Math.max( here_ans , map[a][b] + map[a+1][b]+map[a][b-1] + map[a-1][b]);
            if( b<col-1) here_ans = Math.max( here_ans , map[a][b] + map[a+1][b]+map[a][b+1] + map[a-1][b]);
        }
        return here_ans;
    }

}