package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class JAVA10815{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num_arr = sc.nextInt();
        int[] arr = new int[num_arr];
        for( int i = 0; i < num_arr; i++){
            arr[i] =sc.nextInt();
        }
        Arrays.sort(arr);
        int test_num = sc.nextInt();
        for( int i = 0; i < test_num; i++){
            int now = sc.nextInt();
            if( binarySearch( now , arr ) ) sb.append(1 + " ");
            else sb.append(0 + " ");
        }
        System.out.println(sb);

    }

    public static boolean binarySearch( int num , int[] arr){
        int left_idx = 0;
        int right_idx = arr.length-1;
        while( left_idx <= right_idx ){
            int mid_idx = ( left_idx + right_idx ) / 2;
            int mid = arr[mid_idx];
            if( num < mid ) right_idx = mid_idx -1;
            else if( num > mid ) left_idx = mid_idx + 1;
            else return true;
        }
        return false;

    }
}