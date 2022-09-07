import java.util.Deque;
import java.util.LinkedList;

public class Main {
	
	// :)
	
	public static Deque<Integer> deque = new LinkedList<Integer>(); // <--- this is the array thing
	
	public static void main(String[] args)
	{
		
	// lets fill it
		for (int i = 0; i < 5; i++)
			deque.push((int)(Math.random() * 10 - 1));
		
		System.out.println(deque);
		
		
	// lets make some changes 
		insertFront(1);
		
		System.out.println(deque);

		insertBack(19);
		
		System.out.println(deque);
		
		removeFront();
		
		System.out.println(deque);
		
		removeBack();
		
		System.out.println(deque); 
	}
	
	
	public static void insertFront(int k)
	{
		deque.offerFirst(k);
	}
	
	public static void insertBack(int k)
	{
		deque.offerLast(k);
	}
	
	public static void removeFront()
	{
		deque.pollFirst();
	}
	
	public static void removeBack()
	{
		deque.pollLast();
	}
	
}
