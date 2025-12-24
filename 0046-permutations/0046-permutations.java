class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ansList= new ArrayList<>();
        permutation(nums,0,ansList);
        return ansList;
    }
    public void permutation(int[] nums,int index,List<List<Integer>> ansList){
       if(index==nums.length){
        List<Integer> ds= new ArrayList();
        for(int i=0;i<nums.length;i++){
         ds.add(nums[i]);
        }
        ansList.add(new ArrayList(ds));
        return ; 
       }
       for(int i=index;i<nums.length;i++){

        swap(i,index,nums);
        permutation(nums,index+1,ansList);
        swap(i,index,nums);
       }
    }
    public void swap(int i,int index,int[] nums){
        int temp=nums[i];
        nums[i]=nums[index];
        nums[index]=temp;
    }
}