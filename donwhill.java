import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] DP;
    static int answer=0;
    static int N;
    static int M;

    static int dfs(int Y, int X){
        if(Y==M-1&&X==N-1){
            return 1;
        }

        if(Y>M||X>N||Y<0||X<0)
            return -1;
        if(DP[Y][X]==-1){
            DP[Y][X]=0;
            if((X+1<N)&&map[Y][X+1]<map[Y][X])
                DP[Y][X]+=dfs(Y,X+1);
            if((Y+1<M)&&map[Y+1][X]<map[Y][X])
                DP[Y][X]+=dfs(Y+1,X);
            if((Y-1>=0)&&map[Y-1][X]<map[Y][X])
                DP[Y][X]+=dfs(Y-1,X);
            if((X-1>=0)&&map[Y][X-1]<map[Y][X])
                DP[Y][X]+=dfs(Y,X-1);
        }


        return DP[Y][X];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String a = br.readLine();
        st = new StringTokenizer(a);
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());;



        map= new int[M][N];
        DP = new int[M][N];
        for(int[] row: DP)
            Arrays.fill(row,-1);

        DP[M-1][N-1]=1;
        for(int i=0;i<M;i++){
            String temp = br.readLine();
            st = new StringTokenizer(temp);
            int j=0;
            while (st.hasMoreTokens()){
                map[i][j++]=Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(DP[0][0]));
        bw.flush();
        bw.close();
    }
}
