class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int answer=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==i){
                continue;
            }else{
                answer=i;
                break;
            }
        }
        if(answer==-1){
            answer=nums.length;
        }
        return answer;
    }
}
