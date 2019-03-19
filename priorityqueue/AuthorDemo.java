package priorityqueue;

public class AuthorDemo {
    public static void main(String[] args)
    {
        Author author1 = new Author("Jules", "Verne");
        Author author2 = new Author("John", "Tolkien");
        Author author3 = new Author("Simon", "Tolkien");
        Author author4 = new Author("Simon", "Tolkien");

        System.out.println(author1.compareTo(author2)); //line 1
        System.out.println(author2.compareTo(author1)); //line 2
        System.out.println(author2.compareTo(author3)); //line 3
        System.out.println(author3.compareTo(author4)); //line 4


    }
}
