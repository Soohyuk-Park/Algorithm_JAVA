package Structure.Tree;

import java.io.*;
        import java.util.*;

public class JAVA14425{
    static int answer = 0;
    static HashMap<String, Integer> map;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        map = new HashMap();
        int a = sc.nextInt();
        int b = sc.nextInt();
        for( int i = 0 ; i< a ; i++){
            String person = sc.next();
            map.put(person,1);
        }
        for( int i = 0; i< b; i++){
            String str = sc.next();
            if( map.get(str) != null){
                answer++;
            }
        }
        System.out.println(answer);

    }

}
