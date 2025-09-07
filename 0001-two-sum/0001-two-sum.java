 import java.util.Hashtable;
class Solution {
    static class Pair{
        int num;
        int index;
        Pair(int num,int index){
            this.num=num;
            this.index=index;
        }
    }
    public int[] twoSum(int[] nums, int target) {
        Pair[] numWithIndex= new Pair[nums.length];
        for( int i=0;i<nums.length;i++){
            numWithIndex[i]=new Pair(nums[i],i);
        }
        Arrays.sort(numWithIndex, Comparator.comparing(p->p.num));
        int left=0,right=numWithIndex.length-1;
        int result=0;
        while(left<right) {
            result = numWithIndex[left].num + numWithIndex[right].num;
            if (result == target) {
                return new int[]{numWithIndex[left].index, numWithIndex[right].index};
            } else if (result < target) {
                left++;
            } else if (result > target) {
                right--;
            }
        }
        return new int[]{-1,-1};
        }
}
