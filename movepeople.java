import java.io.*;
import java.util.*;
import java.util.stream.Collectors;



public class Main {
    static int people=0;
    static int count=0;
    static int visitedNum=0;
    public static void dfs(int[][] nation,int[][] visited,int N,int X, int Y,int L,int R){
        if(X<0||X>=N||Y<0||Y>=N)
            return;

        visited[X][Y]=1;
        people+=nation[X][Y];
        count++;
        visitedNum++;

        if(X-1>=0&&Math.abs(nation[X][Y]-nation[X-1][Y])>=L&&Math.abs(nation[X][Y]-nation[X-1][Y])<=R&&(visited[X-1][Y]==0)){
            dfs(nation,visited,N,X-1,Y,L,R);
        }
        if(X+1<N&&(Math.abs(nation[X][Y]-nation[X+1][Y])>=L)&&(Math.abs(nation[X][Y]-nation[X+1][Y])<=R)&&(visited[X+1][Y]==0)){
            dfs(nation,visited,N,X+1,Y,L,R);
        }
        if(Y-1>=0&&Math.abs(nation[X][Y]-nation[X][Y-1])>=L&&Math.abs(nation[X][Y]-nation[X][Y-1])<=R&&(visited[X][Y-1]==0)){
            dfs(nation,visited,N,X,Y-1,L,R);
        }
        if(Y+1<N&&(Math.abs(nation[X][Y]-nation[X][Y+1])>=L)&&(Math.abs(nation[X][Y]-nation[X][Y+1])<=R)&&(visited[X][Y+1]==0)){
            dfs(nation,visited,N,X,Y+1,L,R);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        int N = 0,L=0,R=0;
        StringTokenizer s_t = new StringTokenizer(st);
        for(;s_t.hasMoreTokens();){
            N=Integer.parseInt(s_t.nextToken());
            L=Integer.parseInt(s_t.nextToken());
            R=Integer.parseInt(s_t.nextToken());
        }
        int[][] nation = new int[N][N];
        int[][] visited = new int[N][N];
        int[][] checked = new int[N][N];
        int moving=0;
        int try_search=0;
        int lastCount=0;
        for(int i=0;i<N;i++){
            st = br.readLine();
            s_t = new StringTokenizer(st);
            for(int j=0;j<N&&s_t.hasMoreTokens();j++){
                nation[i][j]=Integer.parseInt(s_t.nextToken());
            }
        }

        do{
            lastCount=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(visited[i][j]==0){
                        dfs(nation,visited,N,i,j,L,R);
                        if(count==1){
                            checked[i][j]=1;
                            count=0;
                            people=0;
                            continue;
                        }
                        for(int k=0;k<N;k++){
                            for(int l=0;l<N;l++){
                                if(visited[k][l]==1&&count!=0&&checked[k][l]==0){
                                    nation[k][l]=people/count;
                                    checked[k][l]=1;
                                }
                            }
                        }
                        lastCount=Math.max(lastCount,count);
                        count=0;
                        people=0;
                    }else {
                        continue;
                    }
                }
            }
            visited = new int[N][N];
            checked = new int[N][N];
            visitedNum=0;
            if(lastCount!=0)
                moving++;
        }while (lastCount!=0);


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(moving));
        bw.flush();
        bw.close();
    }
}
