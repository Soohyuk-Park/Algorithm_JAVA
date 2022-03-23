package Dynamic;

import java.util.Arrays;
        import java.util.Scanner;
        import java.util.stream.Stream;

        import static java.lang.Math.max;

public class JAVA12865{
    static int weigh;
    static int value;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max_weigh = sc.nextInt();
        int[] table = new int[max_weigh+1];
        Arrays.fill(table,0);
        for( int q =0; q<N;q++){
            weigh = sc.nextInt();
            value = sc.nextInt();
            if( weigh > max_weigh){
                continue;
            }
            else{
                for( int i = max_weigh; i >= 0; i--){
                    if( weigh + i <= max_weigh){
                        table[weigh + i] = max(table[weigh + i], table[i] + value);
                    }
                }
                table[weigh] = max(table[weigh] , value);
            }
        }
        int arrayMax = Arrays.stream(table).max().getAsInt();
        System.out.println(arrayMax);
    }
}
