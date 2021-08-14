package Assignment_4;



public interface LinkedListIntf {
	public void AddAtFront(int element);
	public void AddAtRear(int element);
	public DoublyListNode sortedInsert(int element);  //DoublyListNode head,
	public int[] GetAllElements();
	public DoublyListNode deleteFirst();
	public DoublyListNode deleteLast();
	public void Delete(int element);
	public void displayReverse();
	public void display();

}
