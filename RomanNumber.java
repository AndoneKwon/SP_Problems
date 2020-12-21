class Solution {
    public int returnNumber(char s){
        if(s=='I'){
            return 1;
        }else if(s=='V'){
            return 5;
        }else if(s=='X'){
            return 10;
        }else if(s=='L'){
            return 50;
        }else if(s=='C'){
            return 100;
        }else if(s=='D'){
            return 500;
        }else{
            return 1000;
        }
    }
    
    public int romanToInt(String s) {
        int answer = 0;

        char[] list = s.toCharArray();

        for(int i=0;i<list.length;){
            if(list.length-1<i+1){
                answer += returnNumber(list[i]);
                i++;
            }
            else{
                if(returnNumber(list[i])<returnNumber(list[i+1])){
                    answer+=returnNumber(list[i+1])-returnNumber(list[i]);
                    i+=2;
                }else{
                    answer += returnNumber(list[i]);
                    i++;
                }
            }
        }
        return answer;
    }
}
