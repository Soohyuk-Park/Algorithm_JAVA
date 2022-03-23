package Greedy;

import java.util.Arrays;
        import java.util.Comparator;
        import java.util.PriorityQueue;
        import java.util.Scanner;

class Jewelry{
    int mass;
    int value;

    Jewelry( int mass, int value){
        this.mass = mass;
        this.value = value;
    }
}

public class JAVA1202{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_j = sc.nextInt();
        int num_b = sc.nextInt();
        Jewelry[] jewelrybox = new Jewelry[num_j];
        for( int i = 0 ; i < num_j; i++){
            int m = sc.nextInt();
            int v = sc.nextInt();
            jewelrybox[i] = new Jewelry(m,v);
        }
        Arrays.sort(jewelrybox, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                if (o1.mass == o2.mass) return o2.value - o1.value;

                return o1.mass - o2.mass;
            }
        });

        int[] bags = new int[num_b];
        for( int i = 0 ; i < num_b; i++){
            bags[i] = sc.nextInt();
        }

        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = 0;
        int cnt = 0;
        for ( int i = 0; i < num_b; i++){
            while( cnt < num_j && jewelrybox[cnt].mass <= bags[i]){
                pq.offer(jewelrybox[cnt++].value);
            }

            if( !pq.isEmpty()){
                ans += pq.poll();
            }
        }

        System.out.println(ans);






    }
}

