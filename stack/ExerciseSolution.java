package stack;

public class ExerciseSolution {

    //R-6.4
    public static void transfer(Stack S, Stack T)
    {
        while(!S.isEmpty())
            T.push(S.pop());
    }

    //C-6.17 Demo solution. There's many ways to show this differently.
    public static void main(String[] args)
    {
        Stack<Integer> S = new LinkedStack<>();
        //adding some dummy data
        S.push(5);
        S.push(4);
        S.push(3);
        S.push(2);
        S.push(1);

        Stack<Integer> temp1 = new LinkedStack<>();
        Stack<Integer> temp2 = new LinkedStack<>();
        transfer(S, temp1);
        transfer(temp1, temp2);
        transfer(temp2, S);

        //why do we need the temporary stacks?
    }
}
