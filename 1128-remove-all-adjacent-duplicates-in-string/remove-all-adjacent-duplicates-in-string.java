class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(st.isEmpty() || ch!=st.peek())st.push(ch);
            else{
                st.pop();
            }
        }
        StringBuilder ans =new StringBuilder();
              for(char c : st){
                ans.append(c);
              }
              return ans.toString();
    } 
}