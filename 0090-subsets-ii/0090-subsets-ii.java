class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList=new ArrayList<>();
        List<Integer> ds= new ArrayList<Integer>();
        uniqueSubsets(nums,0,nums.length,ansList,ds);
        return ansList;
    }
    public void uniqueSubsets(int[] nums,int index,int n,List<List<Integer>> ansList,List<Integer> ds){
       
        ansList.add(new ArrayList(ds)); 
    
       for(int i=index;i<n;i++){
        if(i>index && nums[i]==nums[i-1])continue;
          ds.add(nums[i]);
          uniqueSubsets(nums,i+1,n,ansList,ds);
          ds.remove(ds.size()-1);
        }
       }

          
      
    }
    