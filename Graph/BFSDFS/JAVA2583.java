package Graph.BFSDFS;

import java.util.*;

public class JAVA2583 {
    static int cnt;
    static int row;
    static int col;
    static boolean visited[][];
    static int square_num;
    static boolean[][] real_land;
    static int[][] land_info;
    static int[] dx;
    static int[] dy;
    static int temp;
    static ArrayList<Integer> answer;
    public static void main(String[] args) {
        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        real_land = new boolean[row][col];
        visited = new boolean[row][col];
        square_num = sc.nextInt();
        land_info = new int[square_num][4];
        cnt = 0;
        answer = new ArrayList<>(100);
        for (int i = 0; i < square_num; i++) {
            int start_x = sc.nextInt();
            int start_y = sc.nextInt();
            int end_x = sc.nextInt();
            int end_y = sc.nextInt();
            int[] L = new int[]{start_x, start_y, end_x - 1, end_y - 1};
            land_info[i] = L;
        }

        for (int i = 0; i < land_info.length; i++) {
            for (int j = land_info[i][1]; j <= land_info[i][3]; j++) {
                for (int k = land_info[i][0]; k <= land_info[i][2]; k++) {
                    real_land[j][k] = true;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp = 0;
                if( real_land[i][j] == false) {
                    dfs(i, j);
                    cnt++;
                    answer.add(temp);
                }
            }
        }
        answer.sort(Comparator.naturalOrder());
        ArrayList<Integer> realAnswer = new ArrayList<>();
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) != 0) {
                realAnswer.add(answer.get(i));
            }
        }
        int N = realAnswer.size();
        System.out.println(cnt);
        for (int i = 0; i < N; i++) {
            if (i == N - 1) System.out.print(realAnswer.get(i));
            else System.out.print(realAnswer.get(i) + " ");
        }
    }




    public static void dfs( int x, int y ){
        if( real_land[x][y] == false ){
            real_land[x][y] = true;
            temp+=1;
            for( int i = 0 ; i < 4 ; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if( 0<= nx && nx < row && 0<= ny && ny <col){
                    dfs(nx,ny);
                }
            }

        }
        else return;
    }
}

