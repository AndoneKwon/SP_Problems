class Solution {
    public boolean isHappy(int n) {
        char[] arr = Integer.toString(n).toCharArray();
        HashSet<String> set = new HashSet<>();
        String temp;
        int answer=0;
        do{
            int tempInt=0;
            for(char item : arr){
                tempInt+=Math.pow(Integer.parseInt(Character.toString(item)),2);
            }
            temp = Integer.toString(tempInt);
            arr = temp.toCharArray();
            if(set.contains(temp)){
                return false;
            }
            set.add(temp);
            if(temp.compareTo("1")==0)
                return true;
        }while(true);
    }
}

