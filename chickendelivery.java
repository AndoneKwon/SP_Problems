import java.io.*;
import java.util.*;

class shop{
    int x;
    int y;
    shop(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Main {
    static ArrayList<int[]> choiceshops;

    static int checkDistance(List<shop> homeList,List<shop> shopList){
        int total=0;

        for(int i=0;i<homeList.size();i++){
            int distance = 999999;
            for(int j=0;j<shopList.size();j++){
                distance=Math.min(distance,Math.abs(homeList.get(i).x-shopList.get(j).x)+Math.abs(homeList.get(i).y-shopList.get(j).y));
            }
            total+=distance;
        }
        return total;
    }

    static void combination(int[] visited, int start, int n, int r) {

        if(r == 0) {
             choiceshops.add(visited.clone());
        }

        for(int i=start; i<n; i++) {
            visited[i] = 1;
            combination(visited, i + 1, n, r - 1);
            visited[i] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp = br.readLine();
        StringTokenizer st = new StringTokenizer(temp);
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        ArrayList<shop> shoplist = new ArrayList<>();
        ArrayList<shop> homelist = new ArrayList<>();

        for(int i=0;i<N;i++){
            String temp2 = br.readLine();
            st = new StringTokenizer(temp2);
            while(st.hasMoreTokens()){
                for(int j=0;j<N;j++){
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==2){
                    shoplist.add(new shop(i,j));
                }else if(map[i][j]==1){
                    homelist.add(new shop(i,j));
                }
            }
        }//치킨집 위치와 집 위치를 저장한다.
        int shopNum = shoplist.size();

        int[]shops = new int[shopNum];
        choiceshops = new ArrayList<>();

        int answer = 999999999;

        if(shoplist.size()==M){//치킨집과 집의 개수가 모두 같을 경우
            answer=checkDistance(homelist,shoplist);
            System.out.println(answer);
            return;
        }
        else//조합을 구한다.
            combination(shops,0,shopNum,M);

        for(int i=0;i<choiceshops.size();i++){
            shops=choiceshops.get(i);
            ArrayList<shop> tempshop = new ArrayList<>();
            for(int j=0;j<shopNum;j++){
                if(shops[j]==1){
                    tempshop.add(shoplist.get(j));
                }
            }//조합의 경우의 수인 shop을 추가.
            answer=Math.min(checkDistance(homelist,tempshop),answer);
						//조합에 대한 치킨거리를 구하고 최소의 answer를 저장.
        }
        System.out.println(answer);//출력
    }
}
