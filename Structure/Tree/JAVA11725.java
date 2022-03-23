package Structure.Tree;


import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

public class JAVA11725{

    static int n;
    static List<Integer>[] list;
    //일단 리스트로 지정을 해뒀는데
    static boolean[] visit;
    static int[] parents;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        list = new ArrayList[n+1];
        //여기서는 ArrayList로 생성할 수 있는 이유는, 하위(상속??)라서??
        parents = new int[n+1];
        visit = new boolean[n+1];

        for(int i = 1;i<=n;i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<n-1;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);

        }
        dfs(1);
        for(int i = 2;i<=n;i++){
            System.out.println(parents[i]);
        }
    }

    public static void dfs(int v){
        visit[v] = true;

        for(int i : list[v]){
            if(!visit[i]){
                parents[i] = v;
                dfs(i);
            }
        }
    }
}