class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String n : operations){
            if(n.equals("+")){
                int a = stack.pop();
                int b = stack.peek();
                stack.push(a);
                stack.push(a+b);
            }
            else if(n.equals("C")){
                stack.pop();
            }
            else if(n.equals("D")){
                int a = stack.pop();
                stack.push(a);
                stack.push(2*a);
            }
            else{
                stack.push(Integer.parseInt(n));
            }
        }
        int sum = 0;
        for(int n : stack){
            sum = sum+n;
        }
        return sum;
    }
}