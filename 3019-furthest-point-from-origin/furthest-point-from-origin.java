class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int cl=0, cr=0, c_ = 0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i) == 'L') cl++;
            else if(moves.charAt(i) == 'R') cr++;
            else c_ ++;
        }

        return Math.abs(cl-cr) + c_;
    }
}