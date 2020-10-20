package structure.queue;

/**
 * 循环队列 数组版
 */
public class CircularQueue<E> {

	private final E[] array;

	private int head, tail = 0;

	public CircularQueue(int capacity) {
		this.array = (E[]) new Object[capacity];
	}

	//入队
	public boolean enqueue(E e) {
		//检查是否满如果没满添加
		if ((tail + 1) % array.length == head) {
			return false;
		}

		array[tail] = e;
		tail = (tail + 1) & array.length;
		return true;
	}

	public E dequeue() {
		if (tail == head){
			return null;
		}

		E e = array[head];
		head = (head + 1) % array.length;
		return e;

	}

}
