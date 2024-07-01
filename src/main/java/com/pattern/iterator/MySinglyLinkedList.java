package com.pattern.iterator;

interface MyCustomIterator {
  boolean hasNext();
  Object next();
}

class MyListIterator implements MyCustomIterator {
 	private MySinglyLinkedList.Node cur;
  
  	MyListIterator(MySinglyLinkedList.Node nHead) {
    	this.cur = nHead;
    }
  
  	public boolean hasNext() {
     	if (cur == null)
			return false;
      return true;
    }
  
  	public Object next() {
      int temp = cur.data;
      cur = cur.next;
      return temp;
    }
}

interface MyCollection {
	MyCustomIterator iterator(); 
}

public class MySinglyLinkedList implements MyCollection
{
	private Node head = null;
    
    static class Node {
    	public Node next;
        public int data;
        
        Node(int nData) {
        	data = nData;
        	next = null;
        }
    }
        
    public void insertAtBeg(int nData) {
    	Node newNode = new Node(nData);
        if (this.head == null) {
        	this.head = newNode;
        	return;
        }
        newNode.next = this.head;
        this.head = newNode;
    }
  
  	@Override
  	public MyCustomIterator iterator() {
    	return new MyListIterator(head);
    }

	public static void main(String[] args)
	{
		
		// creating a list
		MySinglyLinkedList list = new MySinglyLinkedList();
				
		// elements to be added at the end.
		// in the above created list.
		list.insertAtBeg(40);
		list.insertAtBeg(20);
        list.insertAtBeg(30);
		list.insertAtBeg(10);

		// elements of list are retrieved through iterator.
		MyCustomIterator it = list.iterator();
		while (it.hasNext())
		{
			System.out.print((Integer) it.next() + " ");
		}
	}
}

// This code is contributed by pratham76
