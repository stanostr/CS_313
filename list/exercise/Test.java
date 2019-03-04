package list.exercise;

public class Test {
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<>(5);
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add(2, "7 ");
        for(int i=0; i<list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }
}
