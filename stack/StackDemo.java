package stack;

public class StackDemo {
    public static void main(String[] args)
    {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(5);
        try {
            arrayStack.push(1);
            arrayStack.push(7);
            arrayStack.push(2);
            arrayStack.push(4);
            arrayStack.push(7);
            System.out.println(arrayStack.size()); //line 1
            System.out.println(arrayStack.top()); //line 2
            arrayStack.push(9);
            System.out.println(arrayStack.pop()); //line 3
        }
        catch (IllegalStateException e)
        {
            System.out.println(e.getMessage()); //line 4
        }
        System.out.println(arrayStack.pop()); //line 5

        /*
         * note that the LinkedStack will behave exactly like ArrayStack except that there is no need to
         * deal with any IllegalStateExceptions caused by overflow
         */
    }
}
