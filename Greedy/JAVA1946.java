package Greedy;
// 초기 배열
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class JAVA1946{
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        while( testNum-->0){
            int numPeople = sc.nextInt();
            int[][] arr = new int[numPeople][2];
            sc.nextLine();
            for( int i = 0; i<numPeople; i++){
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, new Comparator<int[]>(){
                @Override
                public int compare(int[] o1, int[] o2){
                    if( o1[0] == o2[0]) return o2[1] - o1[1];
                    else return o1[0] - o2[0];
                }
            });
            int max = arr[0][1];
            int cnt = 1;
            for( int i = 1 ; i < numPeople; i++){
                if( arr[i][1] < max){
                    cnt++;
                    max = arr[i][1];
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);

    }
}
