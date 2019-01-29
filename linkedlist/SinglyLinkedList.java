package linkedlist;

public class SinglyLinkedList<E> {
	
	//a nested class to represent a node
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
	
	//why don't we have a removeLast()?
}