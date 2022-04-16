package Sort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class JAVA2751{
    static int N;
    static int[] arr;
    static int[] tmp;
    public static void MergeSort(int l, int r){
        if (l >= r) return;
        int m = (l + r) >> 1;

        MergeSort(l, m);
        MergeSort(m + 1, r);

        int p1 = l, p2 = m + 1, p3 = l;
        while (p1 <= m && p2 <= r)
            tmp[p3++] = (arr[p1] < arr[p2]) ? arr[p1++] : arr[p2++];
        while (p1 <= m)
            tmp[p3++] = arr[p1++];
        while (p2 <= r)
            tmp[p3++] = arr[p2++];

        for (int i = l; i <= r; i++)
            arr[i] = tmp[i];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        sc.nextLine();
        for( int i = 0 ; i < N ; i ++){
            sb.append(sc.nextLine());
        }

        arr = new int[N];
        tmp = new int[N];

        String hihi = sb.toString();
//        arr = Stream.of(hihi.split("")).mapToInt(Integer::parseInt).toArray();
//        //arr은 우리가 만든 배열이 되었다.
        for( int i =0 ; i< hihi.length(); i++){
            arr[i] = Integer.parseInt(hihi.substring(i,i+1));
        }


        MergeSort(0, N-1 );

        for( int i =0; i<N; i++){
            System.out.println(arr[i]);
        }
    }
}