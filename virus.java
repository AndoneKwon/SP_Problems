package com.company;
import java.io.*;
import java.util.*;

class Point{
    int X;
    int Y;
    int number;

    Point(int x, int y,int number){
        this.X=x;
        this.Y=y;
        this.number=number;
    }
}

public class Main {
    public static void printMap(int[][] map){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map.length;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Deque<Point> queue = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};
        int[][] map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int j=0;
            while (st.hasMoreTokens()){
                map[i][j]=Integer.parseInt(st.nextToken());
                j++;
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            int a=0;
            for(int j=0;j<N;j++){
                if(map[i][j]!=0){
                    queue.offer(new Point(i,j,map[i][j]));
                }
            }
        }

        Point[] a = queue.toArray(new Point[0]);
        Arrays.sort(a,new Comparator<Point>(){
            @Override
            public int compare(Point o1, Point o2) {
                return o1.number-o2.number;
            }
        });

        queue.clear();
        for(Point point : a){
            queue.add(point);
        }

        int checkTurn = 0;
        Deque<Point> tempDeque = new ArrayDeque<>();
        while (checkTurn<S){
            if(queue.isEmpty()){
                break;
            }
            for(int i=0;i<=queue.size();i++){
                tempDeque.offer(queue.poll());
            }
            while (!tempDeque.isEmpty()) {
                Point p = tempDeque.poll();
                for (int i = 0; i < 4; i++) {
                    if (p.X + dx[i]>=0&&p.Y + dy[i]>=0&&p.X + dx[i]<N&&p.Y + dy[i]<N&&map[p.X + dx[i]][p.Y + dy[i]] == 0) {
                        map[p.X + dx[i]][p.Y + dy[i]] = p.number;
                        queue.offer(new Point(p.X + dx[i], p.Y + dy[i], p.number));
                    }
                }
            }
            //printMap(map);
            checkTurn++;
        }

        bw.write(Integer.toString(map[X-1][Y-1]));
        bw.flush();
        bw.close();
    }
}
