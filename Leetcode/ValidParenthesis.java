import java.util.*;

//leetcode 20
public class ValidParenthesis {

    public static void main(String[] args) {
        System.out.println(isValid("{()()}"));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();

        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (!pop.equals(map.get(c))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
