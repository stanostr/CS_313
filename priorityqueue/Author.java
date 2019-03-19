package priorityqueue;

/**
 * To demonstrate a real-life use of the Comparable interface
 */
public class Author implements Comparable<Author> {
    private String firstName;
    private String lastName;

    /** Compares the authors by last name, first name. */
    @Override
    public int compareTo(Author other) {
        int last = this.lastName.compareTo(other.lastName);
        if(last != 0) return last;
        else return this.firstName.compareTo(other.firstName);
    }


    public Author(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
