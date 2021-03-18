import java.io.*;
import java.util.*;


public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void input(int arr[][], int n) throws IOException {
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    public static void dfs(int arr[][], int now) {

    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        long[] dp = new long[n+1];

        long answer = 0;

        Arrays.fill(dp, 0);
        input(arr, n);

        //DP 첫번째 요소 초기화

        for (int i = 0; i < n; i++) {
            //전까지 봤던 Max 값을 업데이트(날짜 무시하고 넘어가는 경우도 있기 떄문에)
            answer = Math.max(answer, dp[i]);
            if (i + arr[i][0] <= n) {
                //날짜가 n보다 같거나 작을때만 계산
                //최대값에 dp를 더하여 업데이트
                dp[i + arr[i][0]] = Math.max(answer + arr[i][1],dp[i + arr[i][0]]);
            }
        }

        for(long item : dp) {
            answer = Math.max(answer, item);
        }

        bw.write(Long.toString(answer));
        bw.flush();
        bw.close();
    }
}

