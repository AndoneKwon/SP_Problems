import java.io.*;
import java.util.*;
import java.util.Collections;

class stage{
    int stage;
    float failer;

    stage(int a, float b){
        this.stage = a;
        this.failer = b;
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        ArrayList<stage> st = new ArrayList<>();
        Deque<Integer> stageslist = new ArrayDeque<Integer>();
        Arrays.sort(stages);
        ArrayList<Integer> answerList = new ArrayList<>();
        for(int item :stages){
            stageslist.add(item);
        }
        for(int i=1;i<N+1;i++){
            int arrive=stageslist.size();
            int nonclear=0;
            for(int item:stageslist){
                if(item==i){
                    nonclear++;
                    stageslist.removeFirst();
                }
            }
            if(arrive==0){
                st.add(new stage(i,0));
                continue;
            }
            float failer = (float) nonclear/arrive;
            st.add(new stage(i,failer));
        }

        Collections.sort(st, new Comparator<stage>() {
            @Override
            public int compare(stage o1, stage o2) {
                if(o1.failer>o2.failer){
                    return -1;
                }else if(o1.failer==o2.failer){
                    return 0;
                }else{
                    return 1;
                }

            }
        });

        for(int i=0;i<N;i++){
            answer[i]=st.get(i).stage;
        }

        return answer;
    }
}
