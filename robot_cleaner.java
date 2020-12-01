import java.io.*;
import java.util.*;

public class Main {
    static int[] totalPrice;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int count=0;
        int full=0;

        int X=Integer.parseInt(st.nextToken());
        int Y=Integer.parseInt(st.nextToken());
        int direction=Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==0)
                    full++;
            }
        }

        map[X][Y]=2;//청소완료
        count++;

        int tryMove=0;
        boolean Move = true;
        while(Move){
            tryMove++;

            int nextX=X;
            int nextY=Y;

            if(direction==0){
                nextY=Y-1;
            }else if(direction==1){
                nextX=X-1;
            }else if(direction==2){
                nextY=Y+1;
            }else if(direction==3){
                nextX=X+1;
            }

            if(map[nextX][nextY]==0){
                map[nextX][nextY]=2;
                X=nextX;
                Y=nextY;
                count++;
                tryMove=0;
                direction--;
                if (direction==-1)
                    direction=3;

                continue;
            }

            if(tryMove!=5&&(map[nextX][nextY]==1||map[nextX][nextY]==2)){
                direction--;
                if(direction==-1){
                    direction=3;
                }
                continue;
            }

            if(tryMove==5){
                //System.out.println("Try Back");
                int backX=X;
                int backY=Y;
                if(direction==0){
                    backX=X+1;
                }else if(direction==1){
                    backY=Y-1;
                }else if(direction==2){
                    backX=X-1;
                }else if(direction==3) {
                    backY=Y+1;
                }
                if(map[backX][backY]==1){
                    Move=false;
                }else{
                    tryMove=0;
                    X=backX;
                    Y=backY;
                    continue;
                }
            }

        }
        System.out.println(count);
        bw.flush();
        bw.close();
    }
}
