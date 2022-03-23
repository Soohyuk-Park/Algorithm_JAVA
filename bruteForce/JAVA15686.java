package bruteForce;

import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        import java.util.Scanner;
        import java.util.stream.Stream;

public class JAVA15686{
    static boolean[] open;
    static ArrayList<int[]> house;
    static ArrayList<int[]> chk_house;
    static int num_chk;
    static int res;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        ans = Integer.MAX_VALUE;
        ArrayList<int[]> house = new ArrayList<>();
        ArrayList<int[]> chk_house = new ArrayList<>();
        int num_chk = sc.nextInt();
        int[][] map = new int[row][row];
        for( int i = 0; i< row; i++){
            for( int j =0;j<row; j++){
                map[i][j] = sc.nextInt();
            }
        }
        for( int i = 0; i< row;i++){
            for( int j =0;j<row;j++){
                if( map[i][j] == 1 ) {
                    int[] now = new int[]{i, j};
                    house.add(now);
                }
            }
        }
        for( int i = 0; i< row;i++){
            for( int j =0;j<row;j++){
                if( map[i][j] ==2 ) {
                    int[] now = new int[]{i, j};
                    chk_house.add(now);
                }
            }
        }
        open = new boolean[chk_house.size()];

        DFS(0,0,house,chk_house,num_chk);

        System.out.println(ans);


    }

    public static void DFS(int start, int cnt, ArrayList<int[]> house,ArrayList<int[]> chk_house, int num_chk) {
        if (cnt == num_chk) {
            int res = 0;
            for (int i = 0; i < house.size(); i++) {
                int temp = Integer.MAX_VALUE;
                // 어떤 집과 치킨집 중 open한 치킨집의 모든 거리를 비교한다.
                // 그 중, 최소 거리를 구한다.
                for (int j = 0; j < chk_house.size(); j++) {
                    if (open[j]) {
                        int distance =( Math.abs(house.get(i)[0] - chk_house.get(j)[0]) + Math.abs(house.get(i)[1]- chk_house.get(j)[1]) );
                        temp = Math.min(temp, distance);
                    }
                }
                res += temp;
            }
            ans = Math.min(ans, res);
            return;
        }
        // 백트래킹
        for (int i = start; i < chk_house.size(); i++) {
            open[i] = true;
            DFS(i + 1, cnt + 1, house, chk_house,num_chk);
            open[i] = false;
        }

    }
}