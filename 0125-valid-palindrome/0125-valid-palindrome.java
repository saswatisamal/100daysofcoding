class Solution {
    public boolean isPalindrome(String s) {
       String result = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
       System.out.println(result);
       int len=result.length();
       int high=len-1,low=0;
       while(low<high){
        if(result.charAt(high)==result.charAt(low)){
        low++;
        high--;
       }else{
        return false;
       }
    }
    return true;
}
}