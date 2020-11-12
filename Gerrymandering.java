import java.io.*;
import java.util.*;

class Group{
    int groupNum;
    ArrayList<Integer> connects = new ArrayList<>();

    Group(int groupNum){
        this.groupNum=groupNum;
    }
}

public class Main {
    static Deque<int[]> choice = new ArrayDeque<>();
    static ArrayList<ArrayList> connect;
    public static void combine(int[] visited,int start ,int n, int r){
        if(r==0){
            choice.add(visited.clone());
        }
        for(int i=start;i<n;i++){
            visited[i]=1;
            combine(visited,i+1,n,r-1);
            visited[i]=0;
        }
    }

    public static boolean checkConnection(Group groups,int[] temparray){
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> finished = new HashSet<>();
        deque.add(groups.connects.get(0));
        int groupNum=0;
        int whatGroup=0;
        if(groups.groupNum==0){
            whatGroup=0;
        }else {
            whatGroup=1;
        }
        while (!deque.isEmpty()){
            groupNum++;
            int a = deque.poll();
            finished.add(a);
            for(int i=0;i<connect.get(a).size();i++){
                if(!finished.contains((Integer)connect.get(a).get(i))&&temparray[(Integer)connect.get(a).get(i)]==whatGroup)
                    deque.add((Integer)connect.get(a).get(i));
            }
        }
        if(finished.size()==groups.connects.size()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] peoples = new int[n];
        int[] choiceCity = new int[n];
        String temp = br.readLine();
        StringTokenizer st = new StringTokenizer(temp);
        int cityNum=0;
        while (st.hasMoreTokens()){
            peoples[cityNum]=Integer.parseInt(st.nextToken());
            cityNum++;
        }

        connect = new ArrayList<>();

        cityNum=0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            connect.add(new ArrayList<Integer>());
            while (st.hasMoreTokens()){
                connect.get(i).add(Integer.parseInt(st.nextToken())-1);
            }
        }

        for(int i=1;i<n/2+1;i++)
            combine(choiceCity,0,n,i);



        ArrayList<Integer> groupA = new ArrayList<>();



        int answer = Integer.MAX_VALUE;

        while (!choice.isEmpty()){
            Group Agroup = new Group(0);
            Group Bgroup = new Group(1);
            Set<Integer> tempGroupA = new HashSet<>();
            Set<Integer> tempGroupB = new HashSet<>();
            int a=0;
            int b=0;
            int[] tempChoice = choice.poll();
            for(int i=0;i<n;i++){
                if(tempChoice[i]==0){
                    Agroup.connects.add(i);
                }else {
                    Bgroup.connects.add(i);
                }
            }


            if(!checkConnection(Agroup,tempChoice)||!checkConnection(Bgroup,tempChoice))
                continue;
            for(int i=0;i<n;i++){
                if(Agroup.connects.contains(i)){
                    a+=peoples[i];
                }else {
                    b+=peoples[i];
                }
            }
            
            answer=Math.min(Math.abs(a-b),answer);
        }
        if(answer==Integer.MAX_VALUE)
            answer=-1;
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}
