
public class ArrayQueue implements Queue {
	public static Node[] q = new Node[98765432];
	private int size = 0;
	private Node head = new Node(null, 0);
	private Node back = head;

	
	public boolean isEmpty() {
		return size == 0;
	}
	public boolean isFull() {
		return size == q.length;
	}
	
	public void add(Object object) {
		if (isFull()) throw new IllegalStateException("the queue is full");
		if (back.object == head.object && size == 0) {
			head = new Node(object, head.idx);
			back = head;
			q[head.idx] = back;
		}
		else if (back.idx >= q.length - 1 ) {
			back = q[0] = new Node(object, 0);
		} else {
			back = q[back.idx + 1] = new Node(object, back.idx + 1);
		}
		++size;
		System.out.printf("	add : The queue has %d clients\n", size);
	}
	
	public Object first() {
		if (size == 0) throw new IllegalStateException("the queue is empty");
		return q[head.idx].object;
	}
	
	public Object remove() {
		if (size == 0) throw new IllegalStateException("the queue is empty");
		Node tmp_;
		tmp_ = q[head.idx];
		if (back.object == head.object && size == 1) {
			--size;
			System.out.printf("	remove: The queue has %d clients\n", size);
			return tmp_.object;
		}
		if(head.idx >= q.length -1) {
			head = q[0];
		}
		else { 
			head = q[head.idx + 1];
		}
		--size;
		System.out.printf("	remove: The queue has %d clients\n", size);
		
		return tmp_.object;	
	}
	
	public int size() {
		return size;
	}
	
	public static class Node {
		Object object;
		private int idx;
		
		Node(Object object, int idx) {
			this.object = object;
			this.idx = idx;
		}
	}
	
}
