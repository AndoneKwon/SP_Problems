class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            list.add(new ArrayList<Integer>());
        }
        for(int i = 0;i<numRows;i++){
            for(int j=0;j<=i;j++){
                if(i==0){
                    list.get(0).add(1);
                }else if(i==1){
                    list.get(1).add(1);
                    list.get(1).add(1);
                    break;
                }else if(j==0||j==i){
                    list.get(i).add(1);
                }else{
                    list.get(i).add(list.get(i-1).get(j-1)+list.get(i-1).get(j));
                }
            }
        }
        return list;
    }
}
