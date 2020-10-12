import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-10-12
 * Time:20:14
 **/
public class TestDemo {

    public static boolean valid(String s){
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //判定c是否为左括号,是则入栈
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if (stack.empty()){
                return false;
            }
            Character top = stack.pop();
            if (map.get(top) == c){
                continue;
            }
           /* if (top == '(' && c == ')'){
                continue;
            }
            if (top == '[' && c == ']'){
                continue;
            }
            if (top == '{' && c == '}'){
                continue;
            }*/
            return false;
        }
        if (stack.empty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(valid(s));
    }
}
