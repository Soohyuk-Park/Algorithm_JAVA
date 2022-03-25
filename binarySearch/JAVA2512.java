package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class JAVA2512 {
    static int[] arr;
    static int n;
    static int my_cost;
    static int target;
    static int left;
    static int right;
    static int mid;
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    arr=new int[n];
    for( int i = 0; i< n ; i++) {
        arr[i] = sc.nextInt();
    }
    Arrays.sort(arr);
    left = 0;
    right = arr[arr.length -1];
    target = sc.nextInt();
    while( left <= right ){
        int sum = 0;
        mid = ( left + right ) / 2 ;
        for( int i = 0 ; i < arr.length; i++){
            if( arr[i] > mid ) sum+= mid;
            else sum+= arr[i];
        }
        //System.out.println(sum);
        //System.out.println(right + " " + mid);
        if( sum > target) right = mid - 1;
        else left = mid + 1;
    }
        System.out.println(right);
    }
}
