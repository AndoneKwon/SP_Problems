package com.company;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.FileHandler;

class Point {
    int x;
    int y;
    int lupy;

    Point(int x, int y,int lupy) {
        this.x = x;
        this.y = y;
        this.lupy=lupy;
    }
}

public class Main {
    static int[] totalPrice;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        ArrayList<Integer> ans = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        while (N!=0){
            int[][] map = new int[N][N];
            int[][] distance = new int[N][N];
            int[][] vistied = new int[N][N];
            int[] dx = {0,1,0,-1};
            int[] dy = {1,0,-1,0};
            PriorityQueue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>(){
                @Override
                public int compare(Point o1, Point o2) {
                    return o1.lupy-o2.lupy;
                }
            });
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    distance[i][j]=Integer.MAX_VALUE;
                }
            }

            for(int i=0;i<N;i++){
                String temp = br.readLine();
                st = new StringTokenizer(temp);
                int number=0;
                while (st.hasMoreTokens()){
                    map[i][number]=Integer.parseInt(st.nextToken());
                    number++;
                }
            }

            distance[0][0]=map[0][0];
            queue.add(new Point(0,0,map[0][0]));

            while (!queue.isEmpty()){
                Point now = queue.poll();
                for(int i=0;i<4;i++){
                    int X = now.x+dx[i];
                    int Y = now.y+dy[i];
                    if(X<0||Y<0||X>=N||Y>=N) continue;
                    if(map[X][Y]+distance[now.x][now.y]<distance[X][Y]){
                        queue.add(new Point(X,Y,map[X][Y]));
                        distance[X][Y]=Math.min(distance[X][Y],map[X][Y]+distance[now.x][now.y]);
                    }
                }
            }

            ans.add(distance[N-1][N-1]);
            N = Integer.parseInt(br.readLine());

        }

        for(int i=0;i<ans.size();i++){
            bw.write("Problem " + (i+1)+": ");
            bw.write(Integer.toString(ans.get(i)));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
