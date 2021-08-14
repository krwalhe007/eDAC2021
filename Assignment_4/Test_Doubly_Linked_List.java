package Assignment_4;
import java.util.Scanner;
public class Test_Doubly_Linked_List {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DoublyLinkedList d = new DoublyLinkedList();
		System.out.println("***************Doubly Linked List*****************");
		int ch = 0;
		while(ch != 10) 
		{
			System.out.println("\n1. Insert at First \n2. Insert at Last "
					+ "  \n3. Display Reverse \n4. Count \n5. Delete First \n6. Delete Last \n7. Insert Sorted  \n8. Display  \n9. Delete Perticular \n10. Exit "
					+ "\n Enter your choice:");
			ch = sc.nextInt();
			switch(ch) 
			{
			case 1 :
				System.out.println("Enter the value:");
				int a = sc.nextInt();
				d.AddAtFront(a);
				System.out.println("Inserted:" +a);
				break;
			case 2 :
				System.out.println("Enter the value:");
				int b = sc.nextInt();
				d.AddAtRear(b);
				System.out.println("Inserted:" +b);
				break;
			case 3 :
				System.out.println("Reverse Order is:");
				d.displayReverse();
				break;
			case 4 : 
				System.out.println("Total Nodes are:");
				d.size();
				break;
			case 5 :
				d.deleteFirst();
				System.out.println("Deleted Successfully !");
				break;
			case 6 :
				d.deleteLast();
				System.out.println("Deleted Successfully !");
				break;
			case 7 : 
				System.out.println("Enter the value:");
				int c = sc.nextInt();
				d.sortedInsert(c);
				System.out.println("Inserted:" +c);
				break;
			case 8 :
				System.out.println("Elements are:");
				d.display();
				break;
			case 9 :
				System.out.println("Enter the element which you want to delete:");
				int j = sc.nextInt();
				d.Delete(j);
				System.out.println("Deleted Successfully !");
				break;
			case 10 : 
				System.out.println("Exited !");
				break;
			default :
				System.out.println("Invalid Input, please try Again.");
				
			}
		}
       sc.close();
	}

}
