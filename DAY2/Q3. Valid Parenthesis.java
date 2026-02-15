
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char i : s.toCharArray()){
            if(isBracketOpen(i)){
                stack.push(i);
            }
            else{
                if(stack.size() == 0){
                    return false;
                }
                else{
                    if(areBracketMatching(stack.peek(),i)){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        return stack.size()==0;
    }
    public boolean isBracketOpen(char c){
        switch(c){
            case '(':
            case '{':
            case '[':
                return true;
            default:
                return false;
        }
    }

    public boolean areBracketMatching(char open , char close){
        if(open=='(' && close==')'){
            return true;
        }
        else if(open=='{' && close=='}'){
            return true;
        }
        else if(open=='[' && close==']'){
            return true;
        }
        else{
            return false;
        }
    }
}
