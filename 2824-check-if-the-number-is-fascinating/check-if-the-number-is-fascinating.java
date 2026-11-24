class Solution {
    public boolean isFascinating(int n) {
        String str1 = Integer.toString(n);
        String str2= Integer.toString(2*n);
        String str3= Integer.toString(3*n);
        
        String result = str1 +str2+str3;
        boolean seen[] = new boolean[10];
        if(result.length()!=9) return false;
        for(int i=0; i<result.length(); i++){
            char ch = result.charAt(i);
            if(ch=='0') return false;
            int digit = ch-'0';
            if (seen[digit]) {
                return false;
            }
            
            seen[digit] = true;
        }
        return true;
    }
}