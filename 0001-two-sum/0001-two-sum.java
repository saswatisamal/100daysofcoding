 import java.util.Hashtable;
class Solution {
    public int[] twoSum(int[] nums, int target) {
      HashMap<Integer,Integer> hm= new HashMap();
      int rem=0;
      for(int i=0;i<nums.length;i++){
        rem=target-nums[i];
        if(hm.containsKey(rem)){
            return new int[]{hm.get(rem),i};
        }else{
            hm.put(nums[i],i);
        }
      }
      return new int[]{-1,-1};
    }
}
