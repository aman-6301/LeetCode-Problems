class Solution {
    List<String> res = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        StringBuilder curr = new StringBuilder();
        
        solve(curr,n);
        return res;
        
    }

    private void solve(StringBuilder curr, int n){
        if(curr.length() == 2*n){
            if(isValid(curr)){
                res.add(curr.toString());
            }
            return;
        }

        curr.append('(');
        solve(curr,n);

        curr.deleteCharAt(curr.length()-1);

        curr.append(')');
        solve(curr,n);
        curr.deleteCharAt(curr.length() - 1);

    }

    private boolean isValid(StringBuilder curr){
        int count = 0;
        for(int i=0;i<curr.length();i++){
            if(curr.charAt(i) == '(')  count++;
            else count--;
            if(count < 0) return false;
        }

        return count == 0;
    }
}