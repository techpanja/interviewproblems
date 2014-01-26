package stackqueues.parenthesismatching;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Check if opening parenthesis pattern matches closing parenthesis pattern.
 * Created by techpanja
 * Created on 1/25/14 4:41 PM.
 */
public class ParenthesisMatching {

    private static final Set<String> openingParenthesisSet = new HashSet<>();
    private static final Set<String> closingParenthesisSet = new HashSet<>();

    static {
        openingParenthesisSet.add("{");
        openingParenthesisSet.add("[");
        openingParenthesisSet.add("(");
        closingParenthesisSet.add("}");
        closingParenthesisSet.add("]");
        closingParenthesisSet.add(")");
    }

    private ParenthesisMatching() {

    }

    /*
    * Allowed parenthesis are: { } ( ) [ ]
    * */
    public static boolean isParenthesisBalanced(String str) {
        Stack<Character> parenthesisStack = new Stack<>();
        if (str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (openingParenthesisSet.contains(String.valueOf(currentChar))) {
                parenthesisStack.push(str.charAt(i));
            } else if (closingParenthesisSet.contains(String.valueOf(currentChar))) {
                if (parenthesisStack.empty()) {
                    return false;
                }
                char stackTopChar = parenthesisStack.peek();
                if (currentChar == '}' && stackTopChar == '{' ||
                        currentChar == ')' && stackTopChar == '(' ||
                        currentChar == ']' && stackTopChar == '[') {
                    parenthesisStack.pop();
                } else {
                    return false;
                }
            }
        }
        return parenthesisStack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isParenthesisBalanced("{{}{}}()(([]))"));
        System.out.println(isParenthesisBalanced("(()){}()"));
        System.out.println(isParenthesisBalanced("[()]{}{[()()]()}"));
        System.out.println(isParenthesisBalanced("(()){[}]()(())"));
        System.out.println(isParenthesisBalanced("[(])"));
        System.out.println(isParenthesisBalanced("{[}]"));
    }
}
