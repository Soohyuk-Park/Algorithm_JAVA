package bruteForce;

import java.util.*;
        import java.util.stream.Stream;

public class JAVA14503{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int column = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int dir = sc.nextInt();
        int cnt = 0;
        int total = 0;
        boolean bool = true;
        int[] robot_info = new int[]{x,y,dir};
        ArrayList<int[]> L = new ArrayList<>();
        L.add(new int[]{-1, 0});
        L.add(new int[]{0, 1});
        L.add(new int[]{1, 0});
        L.add(new int[]{0, -1});
        int[][] map = new int[row][column];
        boolean[][] clean = new boolean[row][column];
        for( int i = 0; i < row; i++){
            for( int j =0;j<column;j++){
                map[i][j] = sc.nextInt();
            }
        }
        while( bool ){
            int cycle = 0;
            int now_x = robot_info[0];
            int now_y = robot_info[1];
            int now_dir = robot_info[2];
            clean[now_x][now_y] = true;
            for( int i = 0 ; i < 4; i++){
                int go = (now_dir + 3*(i+1) ) % 4;
                int dx = now_x +  L.get(go)[0];
                int dy = now_y + L.get(go)[1];
                if( map[dx][dy] == 0 && clean[dx][dy] == false){
                    clean[dx][dy] = true;
                    total +=1;
                    robot_info = new int[]{dx,dy,go};
                    break;
                }
                else cycle+=1;
                if( cycle == 4){
                    dx = now_x -  L.get(go)[0];
                    dy = now_y - L.get(go)[1];
                    if( map[dx][dy] == 0){
                        robot_info = new int[]{dx,dy,go};
                    }
                    else{
                        bool = false;
                    }
                }

            }

        }
        System.out.println(total + 1);
    }
}