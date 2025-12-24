class Solution {
    public List<List<String>> partition(String s) {
       List<List<String>> ansList= new ArrayList<>();
       List<String> temp= new ArrayList();
       palindromePartition(s,0,s.length(),temp,ansList);
       return ansList;
        
    }
    public void palindromePartition(String input, int index, int n, List<String> temp, List<List<String>> result){
       if(input.length()==index){
        result.add( new ArrayList(temp));
        return;
       }
       for(int i = index;i<n;i++){
           if(isPalindrome(input,index,i)){
               temp.add(input.substring(index,i+1));
               palindromePartition(input,i+1,n,temp,result);
               temp.remove(temp.size()-1);
           }
        }
    }

    public boolean isPalindrome(String str,int start,int end){
        while(start<=end){
            if(str.charAt(start++)!=str.charAt(end--))
                return false;
        }
        return true;
    }
}