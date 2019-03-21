package misc;

public class TheQuestion {
    /**
     * This is the code from the midterm exam #3, both versions.
     * It compiles with no problem, as you can test for yourself.
     */

    private interface myInterface
    {
        void hello();
        void bye();
    }
    private abstract class myAbstractClass implements myInterface
    {
        public void hello() { System.out.println("Hi"); }
        public abstract void hello2();
    }
    private class myConcreteClass extends myAbstractClass {
        public void bye() {}
        public void hello2() {
            System.out.println("Hi again");
        }
    }
}
