package Stack;

public class ParenthesisChecker {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char ch: s.toCharArray()){
            if(ch=='('||ch=='{'||ch=='['){
                stack.push(ch);
            }else if(stack.isEmpty()||!isMatchingPair(stack.pop(),ch)){
                return false;
            }
        }
        return stack.isEmpty();
    }
    public boolean isMatchingPair(char opening,char closing){
        return (opening=='('&&closing==')')||(opening=='{'&&closing=='}')||(opening=='['&&closing==']');
    }

    public static void main(String[] args) {
        ParenthesisChecker checker = new ParenthesisChecker();

        // 测试用例
        System.out.println(checker.isValid("()")); // true
        System.out.println(checker.isValid("([{}])")); // true
        System.out.println(checker.isValid("((()))")); // true
        System.out.println(checker.isValid("([)]")); // false
        System.out.println(checker.isValid("(")); // false
    }
}
