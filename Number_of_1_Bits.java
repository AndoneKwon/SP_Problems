public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String number = Integer.toBinaryString(n);
        int answer = 0;
        for(int i=0;i<number.length();i++){
            if(number.charAt(i)=='1')
                answer++;
        }

        return answer;
    }
}
