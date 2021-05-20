package structure.set;

import structure.LinkedList;

public class LinkedSet<E> implements Set<E> {

	private LinkedList<E> list;

	public LinkedSet() {
		this.list = new LinkedList<>();
	}

	@Override
	public void add(E e) {
		if (!list.contains(e)) {
			list.addAtHead(e);
		}
	}

	@Override
	public void remove(E e) {
		list.remove(e);
	}

	@Override
	public boolean contains(E e) {
		return list.contains(e);
	}

	@Override
	public int getSize() {
		return list.size();
	}
}
