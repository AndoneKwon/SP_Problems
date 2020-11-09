import java.io.*;
import java.util.*;

class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Main {
    static ArrayList<int[]> virus=new ArrayList<>();
    static ArrayList<int[]> empty=new ArrayList<>();
    static ArrayList<int[]> wall=new ArrayList<>();
    static Deque<int[]> emptyChoice=new ArrayDeque<>();
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};

    static void printall(int[][] map){
        for(int i=0;i<map.length;i++) {
            for (int j = 0; j < map[0].length; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    static void combination(int[] visited, int start, int n, int r,int spec) {
        if(r == 0&&spec==0) {
            emptyChoice.add(visited.clone());
            return;
        }
        for(int i=start; i<n; i++) {
            visited[i] = 1;
            combination(visited, i + 1, n, r - 1,spec);
            visited[i] = 0;
        }
    }

    static int bfs(int[][] map){
        int answer = 0;

        //System.out.println("before");

        //printall(map);

        int[][] tempmap = Arrays.stream(map).map(int[]::clone).toArray(int[][]::new);

        for(int i=0;i<virus.size();i++){
            Deque<Point> pointDeque = new ArrayDeque<>();
            pointDeque.add(new Point(virus.get(i)[0],virus.get(i)[1]));
            while (!pointDeque.isEmpty()){
                int x = pointDeque.peek().x;
                int y = pointDeque.peek().y;
                pointDeque.poll();
                for(int j=0;j<4;j++){
                    if(x+dx[j]>=0&&y+dy[j]>=0&&x+dx[j]<map.length&&y+dy[j]<map[0].length){
                        if(tempmap[x+dx[j]][y+dy[j]]==0){
                            tempmap[x+dx[j]][y+dy[j]]=2;
                            pointDeque.offer(new Point(x+dx[j],y+dy[j]));
                        }
                    }
                }
            }
        }

        //printall(tempmap);

        for(int i=0;i<tempmap.length;i++) {
            for (int j = 0; j < map[0].length; j++){
                if(tempmap[i][j]==0)
                    answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp = br.readLine();
        StringTokenizer st = new StringTokenizer(temp);
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int j=0;
            while (st.hasMoreTokens()){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==0){
                    empty.add(new int[] {i,j});
                }
                if(map[i][j]==1){
                    wall.add(new int[] {i,j});
                }
                if(map[i][j]==2){
                    virus.add(new int[] {i,j});
                }
                j++;
            }
        }
        int visited[] = new int[empty.size()];
        combination(visited,0,visited.length,3,0);

        int answer=-1;

        while (!emptyChoice.isEmpty()){
            int[] tempChoice = emptyChoice.poll();
            List<Point> origin = new ArrayList<>();
            for(int i=0;i<tempChoice.length;i++){
                if(tempChoice[i]==1){
                    map[empty.get(i)[0]][empty.get(i)[1]]=1;
                    origin.add(new Point(empty.get(i)[0],empty.get(i)[1]));
                }
            }
            answer=Math.max(answer,bfs(map));
            for(int i=0;i<3;i++){
                map[origin.get(i).x][origin.get(i).y]=0;
            }//맵 초기화
        }

        System.out.println(answer);
    }
}
