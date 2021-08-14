package Assignment_4;

import java.util.NoSuchElementException;


public class DoublyLinkedList implements LinkedListIntf {
	private DoublyListNode head;
	private DoublyListNode tail;
	private int size;
	
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	public boolean isEmpty() {
		return size==0;
		
	}

	@Override
	public void AddAtFront(int element) {
		// Make space for new element, say newNode.
				// Store element in newNode's data.
				// Set newNode's next to empty.
				// Set newNode's previous to empty.
				DoublyListNode newNode = new DoublyListNode(element);

				// if list is empty then
				if (head == null) {
					// Set head and tail to newNode.
					head = newNode;
					tail = newNode;
					// Stop.
					return;
				}

				// Set neWNode's next to head
				newNode.next = head;
				// Set head's previous to newNode
				head.prev = newNode;
				// Set head to newNode
				head = newNode;
				size++;
	}

	@Override
	public void AddAtRear(int element) {
		DoublyListNode newNode = new DoublyListNode(element);
		 if(isEmpty()) {
			 head=newNode; //assigning newNode value to head
		 }else {
			 tail.next = newNode; // tail is pointing to newNode now
		     newNode.prev = tail; // assigning the value at tail
		 }
		 tail = newNode;  // newNode is at last
		 size++;

	}
	
	public int size() {
		return size;  // return count of nodes
	}
	
	@Override
	public DoublyListNode sortedInsert(int element) {  //DoublyListNode head,
		DoublyListNode newNode = new DoublyListNode(element);
		 if(head==null) 
			 return newNode; //assigning newNode value to head
	
		 DoublyListNode current = head; // this is pointer only
		 DoublyListNode previous = null;   // this is pointer only
		if(element < current.data)   // adding at first position
		{
			newNode.next = current;
			newNode.next = null;
			current.prev = newNode;
			return newNode;
		}
		while(current != null && element>current.data) {
			previous = current;
			current = current.next;
		}
		if(current == null) // element is being added at last of the LL 
		{
			newNode.prev = previous;
			newNode.next = null;
			previous.next = newNode;
		}
		else 
		{
			newNode.prev = previous;
			newNode.next = previous.next;
			previous.next = newNode;
			newNode.next.prev = newNode;
		}
		 size++;
		 return head;
	}

	@Override
	public int[] GetAllElements() {
		int[] listElements;
		/*
				if (head == null) {
					listElements = new int[0];
					return listElements;
				}
		*/
				listElements = new int[GetNodeCount()];
				int i = 0;
				DoublyListNode curr = head;

				while (curr != null) {
					listElements[i] = curr.data;
					++i;
					curr = curr.next;
				}

				return listElements;
			}
	public int GetNodeCount() {
		int count = 0;
		DoublyListNode curr = head;

		// Algo: While current is not empty.
		while (curr != null) {
			++count;
			curr = curr.next;
		}

		return count;
	}
	
	@Override
	public void display() {
		if(head ==null) {
			System.out.println("Empty");
		}else {
			DoublyListNode temp = head;
			while(temp != null) {
				System.out.println(temp.data);
				size++;
				temp =  temp.next;
			}
			
		}
	}
	
    @Override
	public void displayReverse() {
		if(tail==null) 
			System.out.println("Empty");
		else {
			DoublyListNode temp = tail;
			while(temp != null) {
				System.out.println(temp.data);
				temp = temp.prev;
			}
			
		}
	}
    
    @Override
	public void Delete(int element) {
		// Set current to first node of list.
		DoublyListNode curr = head;

		// while (current is not empty) do
		while (curr != null) {
			// if currrent node's data is element then
			if (curr.data == element) {
				// end the loop - Found the element to be deleted.
				break;
			}
		}

		// if current node is empty then
		if (curr == null) {
			// No node to be deleted as element not found OR list is empty.
			// Stop.
			return;
		}

		// if current node is the first node then
		if (curr == head) {
			// Deleting the first node of linked list
			// Set head to current node's next.
			head = curr.next;

			// if head is empty then
			if (head == null) {
				// List had only one node and that we are to delete => List will be empty.
				// Set tail to empty.
				tail = null;
			} else {
				// List is not empty.
				// Set head node's previous to empty.
				head.prev = null;
			}
			// Stop
			return;
		}

		// if current node is the last node then
		if (curr == tail) {
			// Delete the last node of the linked list.
			// Set (current node's previous) node's next to (current node's next);
			curr.prev.next = curr.next;
			// Set tail to (current node's previous).
			tail = curr.prev;
			// Stop.
			return;
		}

		// Set (current node's previous) node's next to (current node's next).
		curr.prev.next = curr.next;
		// Set (current node's next) node's previous to (current node's previous).
		curr.next.prev = curr.prev;
	}
    
	@Override
	public DoublyListNode deleteFirst(){
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		DoublyListNode temp = head;
		if(head==tail) // executes ony when their is one node remaining
		{
			tail=null;
		}else {
			head.next.prev=null; // cutting the ref of sencond node's previous to first
		}
		head = head.next; // head is given to next node
		temp.next = null; // first nodes ref is setting null to mark it for GC
		size--;
		return temp;
	}
	@Override
	public DoublyListNode deleteLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		DoublyListNode temp = tail;
		if(head==tail) {
			head=null;
		}else {
			tail.prev.next = null; // cutting the ref of second last to last
		}
		tail = tail.prev; // tail is pointing on previous now
		temp.prev = null; // last node marked for gc
		size--;
		return temp;
	}

}
