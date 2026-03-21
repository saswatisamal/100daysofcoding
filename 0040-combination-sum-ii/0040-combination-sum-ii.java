class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      Arrays.sort(candidates);
      List<List<Integer>> result= new ArrayList();
      List<Integer> temp=new ArrayList();
      int index=0;

      combinationSumII(candidates,index,temp,result,target);
      return result;
}

public void combinationSumII(int[] candidates,int index,List<Integer> temp,List<List<Integer>> result,int target){
    if(target==0){
           result.add(new ArrayList(temp));
           return;
        }
    for(int i=index;i<candidates.length;i++){
        if(i>index && candidates[i]==candidates[i-1] && target!=0){
         continue;
        }
        
            if(candidates[i]<=target){
                temp.add(candidates[i]);
                combinationSumII(candidates,i+1,temp,result,target-candidates[i]);
                temp.remove(temp.size()-1);
            }
          

        }
    }

}
