class Solution {
    boolean isSafe(char[][] sud,int row,int col,int n){
        //there is no  need for row check because we are placing just one queen in one row 
        //column check
        //we will check all the rows of the column if any of the row has queen then we will return false
        for(int i=0;i<row;i++){
            if(sud[i][col]=='Q')return false;
        }
        //now we will check the left diagonal only above the current row
        int t1=row-1,t2=col-1;
        while(t1>=0 && t2>=0){
            if(sud[t1][t2]=='Q')return false;
            t1--;
            t2--;
        }
        //now we will check the right diagonal only above the current row
        t1=row-1;
        t2=col+1;
        while(t1>=0 && t2<n){
            if(sud[t1][t2]=='Q')return false;
            t1--;
            t2++;
        }
        return true;
    }
    void queen(List<List<String>> ans,char[][] sud,int row,int n){
        if(row>=n){
            List<String> temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(sud[i]));
            }
            ans.add(temp);
            return;
        }
        for(int col=0;col<n;col++){
            if(isSafe(sud,row,col,n)){//safe function checks if it is safe to put the Queen at the 
                sud[row][col]='Q';
                queen(ans,sud,row+1,n);
                sud[row][col]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char sud[][]=new char[n][n];
        for(char ch[]:sud){
            Arrays.fill(ch,'.');
        }
        List<List<String>> ans=new ArrayList<>();
        queen(ans,sud,0,n);
        return ans;
        
    }
}