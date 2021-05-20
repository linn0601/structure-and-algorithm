package structure.map;

public interface Map<K, V> {

	void add(K key, V value);

	V remove(K key);

	boolean contains(K key);

	V get(K k);

	void set(K key, V value);

	int getSize();

	boolean isEmpty();

}
