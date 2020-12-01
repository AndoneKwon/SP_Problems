import java.io.*;
import java.util.*;

class XY{
    int x;
    int y;

    XY(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Main {
    public static char[][] map;
    public static boolean[][] visited;
    public static ArrayDeque<XY> deque;
    public static int answer = 0;

    public static void printMap(char[][] map){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------");

    }

    public static void getBlocks(){
        deque.clear();
        for(int i=0;i<12;i++){
            for(int j=0;j<6;j++){
                if(map[i][j]!='.'){
                    deque.add(new XY(i,j));
                    visited[i][j]=false;
                }else{
                    visited[i][j]=true;
                }
            }
        }
    }

    public static void deleteMap(){
        Deque<XY> deleteDeque = new ArrayDeque<>();
        for(int i=0;i<6;i++) {
            for (int j = 11; j >= 1; j--) {
                if(map[j][i]=='.'&&map[j-1][i]!='.'){
                    deleteDeque.add(new XY(j,i));
                    break;
                }
            }
            while (!deleteDeque.isEmpty()){
                XY now = deleteDeque.poll();
                for(int k=now.x;k>=1;k--){
                    char temp = map[k][now.y];
                    map[k][now.y]=map[k-1][now.y];
                    map[k-1][now.y]=temp;
                }
                for (int j = 11; j >= 1; j--) {
                    if(map[j][i]=='.'&&map[j-1][i]!='.'){
                        deleteDeque.add(new XY(j,i));
                        break;
                    }
                }
                //printMap(map);
            }
        }
        answer++;
        getBlocks();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        map = new char[12][6];
        visited = new boolean[12][6];
        int[] dx = {0,-1,0,1};
        int[] dy = {1,0,-1,0};

        for(int i=0;i<12;i++){
            map[i]=br.readLine().toCharArray();
        }

        //printMap(map);
        deque = new ArrayDeque<>();
        for(int i=0;i<12;i++){
            for(int j=0;j<6;j++){
                if(map[i][j]!='.'){
                    deque.add(new XY(i,j));
                    visited[i][j]=false;
                }else{
                    visited[i][j]=true;
                }
            }
        }

        boolean more=true;
        int deleteCount=0;
        while (!deque.isEmpty()) {
            deleteCount=0;
            while (!deque.isEmpty()) {
                int count = 1;
                ArrayList<XY> deleteList = new ArrayList<>();
                boolean[][] dequeVisited = new boolean[12][6];
                ArrayDeque<XY> tempDeque = new ArrayDeque<>();
                XY now = deque.poll();
                if (visited[now.x][now.y]) {
                    continue;
                }
                tempDeque.add(now);
                while (!tempDeque.isEmpty()) {
                    XY tempNow = tempDeque.poll();
                    visited[tempNow.x][tempNow.y] = true;
                    dequeVisited[tempNow.x][tempNow.y] = true;
                    deleteList.add(tempNow);
                    for (int i = 0; i < 4; i++) {
                        int nextX = tempNow.x + dx[i];
                        int nextY = tempNow.y + dy[i];
                        if (nextX < 0 || nextY < 0 || nextX >= 12 || nextY >= 6) continue;
                        else if ((map[nextX][nextY] == map[tempNow.x][tempNow.y]) && !visited[nextX][nextY] && !dequeVisited[nextX][nextY]) {
                            tempDeque.add(new XY(nextX, nextY));
                            dequeVisited[nextX][nextY] = true;
                        }
                    }
                }
                if (deleteList.size() >= 4) {
                    for (int i = 0; i < deleteList.size(); i++) {
                        map[deleteList.get(i).x][deleteList.get(i).y] = '.';
                    }
                    deleteCount++;
                    more = true;
                    getBlocks();
                    //printMap(map);
                    continue;
                } else {
                    deleteList.clear();
                    //printMap(map);
                }
            }
            if(deleteCount!=0)
                deleteMap();
        }
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}
