package com.company;
import java.io.*;
import java.util.*;

public class Main {
    static int[] totalPrice;
    public static void erase(int[] map,List list){

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int[] ans = new int[T];
        int testcase = 0;
        while (testcase<T){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] times = new int[N];
            int[] before = new int[N];
            int[] finalTime = new int[N];
            ArrayList<Integer>[] list = new ArrayList[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                times[i]=Integer.parseInt(st.nextToken());
            }
            for(int i=0;i<N;i++){
                list[i]=new ArrayList<Integer>();
            }

            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                before[to-1]++;
                list[from-1].add(to-1);
            }
            int des = Integer.parseInt(br.readLine());
            ArrayDeque<Integer> deque = new ArrayDeque<>();

            for(int i=0;i<N;i++){
                if(before[i]==0){
                    deque.add(i);
                    finalTime[i]=times[i];
                }
            }

            while (!deque.isEmpty()){
                int now = deque.poll();
                for(int i=0;i<list[now].size();i++){
                    int next = list[now].get(i);
                    before[next]--;
                    if(before[next]==0){
                        deque.add(next);
                    }
                    finalTime[next] = Math.max(finalTime[next],finalTime[now]+times[next]);
                }
            }

            int localAns = 0;

            ans[testcase]=finalTime[des-1];
            testcase++;
        }

        for(int i=0;i<T;i++){
            bw.write(Integer.toString(ans[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
