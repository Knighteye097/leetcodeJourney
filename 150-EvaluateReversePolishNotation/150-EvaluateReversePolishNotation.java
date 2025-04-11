// Last updated: 4/11/2025, 9:51:27 PM
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Long> stack = new Stack<>();

        for(String str : tokens) {
            if(isOperation(str) && !stack.empty()) {
                Long num2 = stack.pop();
                Long num1 = stack.pop();

                Long res = calculate(num1, num2, str);

                stack.push(res);
            } else {
                stack.push(Long.valueOf(str));
            }
        }


        return stack.pop().intValue();
    }

    private boolean isOperation(String ch) {
        return ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/");
    } 

    private Long calculate(Long num1, Long num2, String operation) {
        switch(operation) {
            case "+" : return num1 + num2;

            case "-" : return num1 - num2;

            case "/" : return num1/num2;

            case "*" : return num1 * num2;

            default : return 1L;
        }
    }  
}