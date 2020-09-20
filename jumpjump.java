```java

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] go = new int[N];
        String temp = br.readLine();
        StringTokenizer st = new StringTokenizer(temp);
        int i=0;
        while (st.hasMoreTokens()){
            arr[i++]=Integer.parseInt(st.nextToken());
        }

        for(int j=0;j<N;j++){
            go[j]=9999999;
        }
        go[0]=0;
        for(int j=0;j<N;j++){
            for(int k=1;k+j<N&&k<=arr[j];k++){
                if(go[k+j]!=99999999){
                    go[k+j]=Math.min(go[j]+1,go[k+j]);
                }
            }
        }
        int answer=0;
        if(go[N-1]==9999999)
            answer=-1;
        else
            answer=go[N-1];
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}
```
