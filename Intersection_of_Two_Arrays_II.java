class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i< nums1.length;i++){
            map1.computeIfPresent(nums1[i],(k,v)->v+1);
            map1.putIfAbsent(nums1[i],1);
        }

        for(int i=0;i< nums2.length;i++){
            map2.computeIfPresent(nums2[i],(k,v)->v+1);
            map2.putIfAbsent(nums2[i],1);
        }

        for(int item : map1.keySet()){
            if(!map1.containsKey(item)||!map2.containsKey(item)){
                continue;
            }
            if(map1.get(item)<map2.get(item)){
                for(int j=0;j<map1.get(item);j++){
                    list.add(item);
                }
            }else{
                for(int j=0;j<map2.get(item);j++){
                    list.add(item);
                }
            }
        }

        int[] arr = new int[list.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=list.get(i);
        }

        return arr;
    }
}
