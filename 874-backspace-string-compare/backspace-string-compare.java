class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder();
        StringBuilder tb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != '#') sb.append(s.charAt(i));
             else if(!sb.isEmpty()) sb.deleteCharAt(sb.length()-1);
        }

        for(int i=0;i<t.length();i++){
            if(t.charAt(i) != '#') tb.append(t.charAt(i));
            else if(!tb.isEmpty()) tb.deleteCharAt(tb.length()-1);
        }

        if(sb.length() != tb.length()) return false;

        return sb.toString().equals(tb.toString());
    }
}