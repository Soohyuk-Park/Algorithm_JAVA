package Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class JAVA11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        sc.nextLine();
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for( int i = 0; i< num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sum = 0;
        int now = 0;
        for( int i = 0; i<num; i++){
            now += arr[i];
            sum += now;
        }
        System.out.println(sum);

    }
}
