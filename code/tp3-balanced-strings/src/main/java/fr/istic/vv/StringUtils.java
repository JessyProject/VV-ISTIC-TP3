package fr.istic.vv;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringUtils {

    public StringUtils() {}

    public boolean isBalanced(String str) {
        Deque<Character> stack
                = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            }
            // check if we start with closed parenthesis
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        return (stack.isEmpty());
    }

}
