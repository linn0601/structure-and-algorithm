package structure.queue;

import java.util.Objects;

/**
 * 顺序队列实现
 */
public class ArrayQueue<E> {

	public final E[] array;

	//定义head 与 tail
	private int head, tail; //下标

	public ArrayQueue(int capacity) {
		array = (E[]) new Objects[capacity];
	}

	//入队操作
	public boolean enqueue(E e) {
		if (tail == array.length - 1) {
			if (head == 0) {
				//表示沾满
				return false;
			}
			//数据搬移
			for (int i = head; i < tail; i++) {
				array[i - head] = array[i];
			}
			//更新 tail 和 head
			tail -= head;
			head = 0;
		}

		array[tail] = e;
		++tail;
		return true;
	}

	//出队
	public E dequeue() {
		//表示为null
		if (head == tail) {
			return null;
		}

		E e = array[head];
		++head;

		return e;
	}
}
