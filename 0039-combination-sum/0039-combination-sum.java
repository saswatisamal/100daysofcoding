class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int candidate) {
     int n=candidates.length;
     List<Integer> temp= new ArrayList();
     List<List<Integer>> result= new ArrayList();
     combine(candidates,0,n,candidate,temp,result);
     return result;
    }
     public void combine(int[] candidates,int ind,int n,int target,List<Integer> temp, List<List<Integer>> result){
        if(ind==n){
            if(target==0)
            result.add(new ArrayList(temp));
            return;
        }
        if(candidates[ind]<=target){
            temp.add(candidates[ind]);
            combine(candidates,ind,n,target-candidates[ind],temp,result);
            temp.remove(temp.size()-1);
        }
         combine(candidates,ind+1,n,target,temp,result);
     }
 }
      