package Greedy;


import java.util.Arrays;
        import java.util.Objects;
        import java.util.Scanner;

public class JAVA1541{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String sik = sc.next();
        String[] arr = sik.split("\\+|\\-");
        String[] arr2 = sik.split("[0-9]+");
        int sum = 0;
        boolean flag = true;
        int chk =0;
        if( arr.length == 1){
            System.out.println(arr[0]);
            return;
        }
        else{
            for( int i = 0 ; i< arr.length; i++){
                if( Objects.equals(arr2[i],"-") && (chk == 0)) {
                    flag = false;
                    chk += 1;
                }
                if(flag)
                    sum+=Integer.parseInt(arr[i]);
                else
                    sum-=Integer.parseInt(arr[i]);

            }
            System.out.println(sum);
        }
    }
}
