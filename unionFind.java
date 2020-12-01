import java.io.*;
import java.util.*;

public class Main {
    static int[] nodes;
    public static void union(int o1, int o2){
        int parent1 = find_root(o1);
        int parent2 = find_root(o2);
        if(parent1>parent2) {
            nodes[parent1] = parent2;
        }
        else {
            nodes[parent2] = parent1;
        }
    };

    public static int find_root(int o1){
        int parents;
        if(nodes[o1]==o1){
            return o1;// 루트 노드미 임을 의
        }
        else{
            parents=find_root(nodes[o1]);
            nodes[o1]=parents;//루트 노드까지 간 뒤 경로를 돌아가며 압축 시킴.
        }
        return parents;
    }

    public static boolean find(int o1, int o2){
        if(o1==o2)//둘이 같은 것이면 어차피 찾을 필요 없기 때문에
            return true;
        else {
            return nodes[find_root(o1)] == nodes[find_root(o2)];//둘이 같은 부모를 가지고 있는 지를 판단하기 위해 root노드를 찾음. 이 과정에서 경로 압축을 또한 행함.
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String temp = br.readLine();
        st = new StringTokenizer(temp);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nodes = new int[N+1];

        for(int i=0;i<N+1;i++){
            nodes[i]=i;
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            int o1 = Integer.parseInt(st.nextToken());
            int o2 = Integer.parseInt(st.nextToken());

            if(oper==0){
                union(o1,o2);
            }
            else{
                if(find(o1,o2))
                    bw.write("YES");
                else
                    bw.write("NO");
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }
}
