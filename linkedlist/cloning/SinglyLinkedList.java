package linkedlist.cloning;

//not how we now implement the Cloneable interface
public class SinglyLinkedList<E> implements Cloneable {
	
   private static class Node<E>
   {
	private E element;
	private Node<E> next;
	//constructor
	public Node(E element, Node<E> next)
	{
		this.element = element;
		this.next = next;
	}
	public E getElement() { return element; } //setter for the data
	public Node<E> getNext() { return next; } //get next Node
	public void setNext(Node<E> next) { this.next = next; } //change next Node
    }
	
    //instance variables of the SinglyLinkedList
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
	
    //default constructor, constructs empty list
    public SinglyLinkedList() {}
	
    public int size() { return size; }
    public boolean isEmpty() { 
	return size==0;
    }	
	
    public E first()
    {
	if(isEmpty()) return null;
		return head.getElement();
    }

    public E last() {
	if(isEmpty()) return null;
	return tail.getElement();
    }
	
    public void addFirst(E e)
    {
	head = new Node<>(e, head);
	if(size == 0) tail = head;
	size++;
    }
	
    public void addLast(E e)
    {
	Node<E> newTail = new Node<>(e, null); 
	if(isEmpty())
 	{
		head = newTail;
	}
	else 
	{
		tail.setNext(newTail);
	}
	tail = newTail;
	size++;
    }
	
    public E removeFirst()
    {
	if(isEmpty()) return null;
		
	//save it before we remove it
	E result = head.getElement(); 
	//remove first node
	head = head.getNext();
	size--;
	if(size==0)
	{
		tail=null;
	}
	return result;
    }

    //this is how it must be done to override the equals method of Object
    @Override
    public boolean equals(Object o)
    {
	if(o==null) return false; //because our list is clearly not null, even if empty

	/*
	* this may be justifiably confusing to students but getClass() returns an object of Class type,
	* and Class objects may be compared with == and != as if they are primitives or Strings
	* but NOT like other reference types.
	* Read more at https://docs.oracle.com/javase/7/docs/api/java/lang/Class.html
	* You do not need to understand the details of how this works.
	*/
	if(getClass() != o.getClass()) return false;

	SinglyLinkedList other = (SinglyLinkedList) o;
	if(size != other.size) return false;
	Node walkA = head;
	Node walkB = other.head;
	while(walkA != null)
	{
		if(!walkA.getElement().equals(walkB.getElement())) return false;
		walkA = walkA.getNext();
		walkB = walkB.getNext();
	}
	return true;
    }

	//Why shouldn't we do it as below instead? Note: it will actually work correctly
	/*
	public boolean equals(SinglyLinkedList other)
	{
		if(other==null) return false; //because our list is clearly not null, even if empty
		if(size != other.size) return false;
		Node walkA = head;
		Node walkB = other.head;
		while(walkA != null)
		{
			if(!walkA.getElement().equals(walkB.getElement())) return false;
			walkA = walkA.getNext();
			walkB = walkB.getNext();
		}
		return true;
	}
	*/

   public SinglyLinkedList<E> clone()
   {
    	//in the book they throw the exception here but
	//it is nicer to the users of our class to simply catch it
	//to not disturb user over an exception that cannot occur
        try {
            SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();
            if (size > 0) {
                other.head = new Node<>(head.getElement(), null);
                Node<E> walk = head.getNext();
                Node<E> otherTail = other.head;
                while (walk != null) {
                    Node<E> newest = new Node<>(walk.getElement(), null);
                    otherTail.setNext(newest);
                    otherTail = newest;
                    walk = walk.getNext();
                }
            }
            return other;
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
