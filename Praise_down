package com.company;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.FileHandler;

public class Main {
    static int[] totalPrice;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        totalPrice = new int[N];
        int[] PriceList = new int[N];

        String temp = br.readLine();
        st = new StringTokenizer(temp);

        ArrayList<ArrayList> mans= new ArrayList<>();
        for(int i=0;i<N;i++){
            ArrayList<Integer> tempList = new ArrayList<>();
            mans.add(tempList);
        }//인접리스트 생성

        int stringNum=0;

        while (st.hasMoreTokens()){
            if(stringNum==0){
                stringNum++;
                st.nextToken();
            }else{
                mans.get(Integer.parseInt(st.nextToken())-1).add(stringNum);
                stringNum++;
            }
        }//자신의 상사를 리스트에 추가함
        Deque<Integer> deque = new ArrayDeque();

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            PriceList[Integer.parseInt(st.nextToken())-1]+=Integer.parseInt(st.nextToken());
        }//칭찬의 시작점을 한번에 저장
        for(int i=0;i<N;i++){
            if(PriceList[i]==0){
                continue;
            }//칭찬을 시작하지 않는 지점은 패스
            totalPrice[i]+=PriceList[i];
            int value = PriceList[i];
            for(int j=0;j<mans.get(i).size();j++){
                deque.add((Integer) mans.get(i).get(j));
            }
            while (!deque.isEmpty()){
                int point = deque.poll();
                totalPrice[point]+=value;
                for(int j=0;j<mans.get(point).size();j++){
                    deque.add((Integer) mans.get(point).get(j));
                }
            }
        }//BFS로 하든 DFS로 하든 상관은 없지만 DFS로 하면 백트래킹을 이용해야 한다.


        for(int item : totalPrice){
            bw.write(Integer.toString(item));
            bw.write(" ");
        }//출력하며 함수 종료
        bw.flush();
        bw.close();
    }
}
