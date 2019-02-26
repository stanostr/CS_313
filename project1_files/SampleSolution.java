public class SampleSolution {

    public static void main(String[] args) {
        CircularLinkedList<PrimeFinder> linkedList = new CircularLinkedList<>();
        for(int i=1; i<=10; i++)
        {
            PrimeFinder thread = new PrimeFinder("PrimeFinder " + i, i * 1000-1000 + 1, i * 1000);
            linkedList.addLast(thread);
        }

        while(!linkedList.isEmpty()) {
            PrimeFinder thread = linkedList.first();
            if (!thread.isFinished()) {
                thread.run(25);
                linkedList.rotate();
            }
            else {
                linkedList.removeFirst();
            }
        }
     }
}
