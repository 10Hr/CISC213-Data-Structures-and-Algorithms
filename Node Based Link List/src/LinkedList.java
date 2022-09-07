
public class LinkedList {

	Node front;
	Node rear;
	
	public boolean empty()
	{
		return (front == null && rear == null);
	}
	
	public void display() 
	{
		if (empty())
			System.out.println("Empty!");
		
		Node temp = front;
		
		while (temp != null) 
		{
			System.out.println(temp.key);
			temp = temp.next;
		}
		
	}
	
	public void insert(int k) 
	{
		if (empty()) {
			front = rear = new Node(k , null);
		return;
		}
		
		Node temp = new Node(k, null);
		
		rear.next = temp;
		rear = rear.next;
		
	}
	
	public void remove()
	{
		if (empty()) 
			System.out.println("Empty!");
		else if (front == rear) 
			front = rear = null; //derefrences the only node in the linked list
		else
			front = front.next;
		
		
		
	}
			
	
}
