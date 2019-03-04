package copying;

public class Test {
    public static void main(String[] a)
    {
        Author author = new Author("Jules Verne");

        Author author2 = author.clone(); //not a copying
        author2.setName("Alexandre Dumas");

        System.out.println("Line 1: " + author.getName()); //line 1

        Book book = new Book("123ISBN", "The Three Musketeers", author);
        Book book2 = book.clone(); //shallow copying

        book2.setTitle("Meditations");
        book2.getAuthor().setName("Marcus Aurelius");
        book2.setAuthor(new Author("Bob"));

        System.out.println("Line 2: " + book.getTitle()); //line 2
        System.out.println("Line 3: " + book.getAuthor().getName()); //line 3

        Book[] books = new Book[3];
        books[0] = new Book("123ISBN", "Book 1", new Author("John"));
        books[1] = new Book("321ISBN", "Book 2", new Author("Jane"));
        books[2] = new Book("987ISBN", "Book 3", new Author("Jill"));

        Library library = new Library("Library of Alexandria", books);
        Library library2 = library.clone(); //deep copying
        library2.setName("The Great Library");
        library2.getBooks()[0].setTitle("Book 10");

        System.out.println("Line 4: " + library.getName()); //line 4
        System.out.println("Line 5: " + library.getBooks()[0].getTitle()); //line 5
        System.out.println("Line 6: " + library2.getBooks()[0].getTitle()); //line 6

    }
}
