package list;

public class ParenthesesTest {
    public static void main(String[] args)
    {
        /*
        Both implementations are correct.
        The ArrayList approach is
        more complicated to write, less readable,
        and, worst of all, it is MUCH slower.
        */
        String validString = "{}{[]}({(())})";
        System.out.println(ValidParentheses.isValid(validString)); //line 1
        System.out.println(ValidParentheses.isValidUsingArrayList(validString)); //line 2
        String invalidString = "({())}";
        System.out.println(ValidParentheses.isValid(invalidString)); //line 3
        System.out.println(ValidParentheses.isValidUsingArrayList(invalidString)); //line 4
        String invalidString2 = "{{{{{((((";
        System.out.println(ValidParentheses.isValid(invalidString2)); //line 5
        System.out.println(ValidParentheses.isValidUsingArrayList(invalidString2)); //line 6
    }

}
