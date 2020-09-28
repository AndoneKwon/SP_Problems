import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> testcase = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();
        StringTokenizer st;
        String a;
        while (true){
            a=br.readLine();
            if(a.equals("0")){
                break;
            }
            boolean b=a.equals(new StringBuffer(a).reverse().toString());
            if(b==true){
                answer.add("yes");
            }else{
                answer.add("no");
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String item : answer){
            bw.write(item);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
