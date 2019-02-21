package list;

import stack.LinkedStack;
import stack.Stack;

public class ValidParentheses {

    /**
     * Tests whether the parantheses in a String are properly matched using a stack.
     * @param s the string to be checked
     * @return true if properly matched, false otherwise
     */
    public static boolean isValid(String s) {
        if(s.length()==0) return true;
        if(s.length()%2==1) return false; //save time

        Stack<Character> stack = new LinkedStack<>();
        for(int i=0; i<s.length(); i++)
        {
            char curr = s.charAt(i);
            if(curr == '(' || curr == '{' || curr == '[')
            {
                stack.push(curr); //O(1)
            }
            else if(curr == ')')
            {
                //notice how if stack is empty (i.e. unclosed brace), then top() will return null
                //and this works in our implementation of stack
                if(stack.top()!='(') return false; //O(1)
                else stack.pop(); //O(1)
            }
            else if(s.charAt(i) == '}')
            {
                if(stack.top()!='{') return false; //O(1)
                else stack.pop(); //O(1)
            }
            else if(s.charAt(i) == ']')
            {
                if(stack.top()!='[') return false; //O(1)
                else stack.pop(); //O(1)
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }

    /**
     * Same as above but using an unbounded ArrayList
     */
    public static boolean isValidUsingArrayList(String s) {
        if (s.length() == 0) return true;
        if (s.length() % 2 == 1) return false;

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(' || curr == '{' || curr == '[') {
                list.add(0, curr); //O(n)
            }
            else if (curr == ')') {
                if(list.isEmpty()) return false; //we now have to add this to avoid exception
                if (list.get(0) != '(') return false; //O(1) still because we always look for element 0
                else list.remove(0); //O(n)
            }
            else if (s.charAt(i) == '}') {
                if(list.isEmpty()) return false;
                if (list.get(0) != '{') return false;
                else list.remove(0); //O(n)
            } else if (s.charAt(i) == ']') {
                if(list.isEmpty()) return false;
                if (list.get(0) != '[') return false;
                else list.remove(0); //O(n)
            }
        }
        if (!list.isEmpty()) return false;
        return true;
    }
}
