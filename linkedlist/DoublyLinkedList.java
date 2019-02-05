public class DoublyLinkedList<E> {
	
	//a nested class to represent a node
	private static class Node<E>
	{
		private E element;
		private Node<E> next;
		private Node<E> prev;
		//constructor
		public Node(E element, Node<E> prev, Node<E> next)
		{
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
		public E getElement() { return element; } //setter for the data
		public Node<E> getPrev() { return prev; } //get previous Node
		public Node<E> getNext() { return next; } //get next Node
		public void setPrev(Node<E> prev) { this.prev = prev; }
		public void setNext(Node<E> next) { this.next = next; } //change next Node
	}
	
	//instance variables of the SinglyLinkedList
	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;
	
	//default constructor, constructs empty list
	public DoublyLinkedList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}
	
	public int size() { return size; }
	public boolean isEmpty() { 
		return size==0;
	}	
	
	public E first()
	{
		if(isEmpty()) return null;
		return header.getNext.getElement();
	}
	
	
	public E last() {
		if(isEmpty()) return null;
		return trailer.getPrev().getElement();
	}
	
	/**
	* Note that this a private helper method. 
	* Users of the class do not have access to this method,
	* as there is no such operation on a doubly (or singly) linked list
	*/
	private void addBetween(E e, Node<E> predecessor, Node<E> successor)
	{
		Node<E> newest = new Node<>(e, predecessor, successor)
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}
	
	public void addFirst(E e)
	{
		addBetween(e, header, header.getNext());
	}
	
	public void addLast(E e)
	{
		addBetween(e, trailer.getPrev(), trailer);
	}
	
	/**
	* Note how this is also a private helper method, 
	* there is no general-case remove operation for a doubly linked list
	*/
	private E remove(Node <E> node)
	{
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement();
	}
	
	public E removeFirst()
	{
		if(isEmpty()) return null;
		//note how we are calling the private remove method, which return an object of type E
		return remove(header.getNext());
	}
	
	public E removeLast()
	{
		if(isEmpty()) return null;
		return remove(trailer.getPrev());
	}
}