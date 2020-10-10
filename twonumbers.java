import java.io.*;
import java.util.*;


public class Main {
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int start=0;
        int end=0;
        int answer=0;
        int n=Integer.parseInt(br.readLine());
        numbers=new int[n];
        st = new StringTokenizer(br.readLine()," ");
        int i=0;
        while (st.hasMoreTokens()){
            numbers[i++]=Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());
        Arrays.sort(numbers);
        
        end=n-1;
        while (start<end&&start<n){
            if(start==end){
                start++;
            }
            if(numbers[start]+numbers[end]==x){{
                answer++;
                start++;
            }
            }else if(numbers[start]+numbers[end]<x){
                start++;
            }else if(numbers[start]+numbers[end]>x){
                end--;
            }
        }
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}
