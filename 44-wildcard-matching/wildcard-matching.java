class Solution {
    public boolean isMatch(String s, String p) {
        int sIdx = 0, pIdx = 0, match = 0, starIdx = -1;
        while (sIdx < s.length()){
            // advancing both pointers
            if (pIdx < p.length()  && (p.charAt(pIdx) == '?' || s.charAt(sIdx) == p.charAt(pIdx))){
                sIdx++;
                pIdx++;
            }
            // * found, only advancing pattern pointer
            else if (pIdx < p.length() && p.charAt(pIdx) == '*'){
                starIdx = pIdx;
                match = sIdx;
                pIdx++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                pIdx = starIdx + 1;
                match++;
                sIdx = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }
        
        //check for remaining characters in pattern
        while (pIdx < p.length() && p.charAt(pIdx) == '*')
            pIdx++;
        
        return pIdx == p.length();
    }
}