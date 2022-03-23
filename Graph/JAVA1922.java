package Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class JAVA1922 {
    static int[][] graph;
    static int[] parent;
    static int total;
    static int num_graph;
    static int num_parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num_parent = sc.nextInt();
        num_graph = sc.nextInt();
        total = 0;
        parent = new int[(num_parent) + 1];
        for( int i = 0; i < num_parent + 1; i++){
            parent[i] = i;
        }
        graph = new int[num_graph][3];
        for( int i = 0 ; i < num_graph; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            int[] q = new int[]{x,y,z};
            graph[i] = q;
        }
        Arrays.sort(graph, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[2] - o2[2];
            }
        });
        for( int i = 0 ; i < graph.length; i++){
            if( find( parent, graph[i][0] ) != find(parent, graph[i][1])  ){
                total += graph[i][2];
                union(parent,graph[i][0],graph[i][1]);
            }
        }
        System.out.println(total);
    }

    public static int find( int[] parent, int i){
        if( parent[i] == i) return i;
        return find( parent, parent[i]);
    }

    public static void union( int[] parent, int a, int b){
        int a_parent = find(parent,a);
        int b_parent = find(parent,b);

        if( a_parent < b_parent ) parent[b_parent] = a_parent;
        else parent[a_parent] = b_parent;
    }
}
