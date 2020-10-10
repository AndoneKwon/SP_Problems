import java.io.*;
import java.util.*;

public class Main {
    static int[] numbers;
    static int MAX=-999999999;
    static int Min=999999999;
    static int n;
    public static void dfs(int[] opers, int sum,int point){

        if(point==n){
            MAX=Math.max(MAX,sum);
            Min=Math.min(Min,sum);
            return;
        }

        if(opers[0]!=0){
            opers[0]-=1;
            dfs(opers,sum+numbers[point],point+1);
            opers[0]+=1;
        }
        if(opers[1]!=0){
            opers[1]-=1;
            dfs(opers,sum-numbers[point],point+1);
            opers[1]+=1;
        }
        if(opers[2]!=0){
            opers[2]-=1;
            dfs(opers,sum*numbers[point],point+1);
            opers[2]+=1;
        }
        if(opers[3]!=0){
            opers[3]-=1;
            dfs(opers,sum/numbers[point],point+1);
            opers[3]+=1;
        }

        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        int[] oper = new int[4];
        String temp = br.readLine();
        st = new StringTokenizer(temp);
        int Now=0;
        int i=0;

        while (st.hasMoreTokens()){
            numbers[i++]=Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        i=0;
        while (st.hasMoreTokens()){
            oper[i++]=Integer.parseInt(st.nextToken());
        }

        dfs(oper,numbers[0],1);

        bw.write(Integer.toString(MAX));
        bw.newLine();
        bw.write(Integer.toString(Min));
        bw.flush();
        bw.close();
    }
}
