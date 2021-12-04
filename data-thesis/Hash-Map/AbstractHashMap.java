package Mini_algorithms;

import java.util.ArrayList;
import java.util.Random;


public abstract class AbstractHashMap<K,V> extends AbstractMap<K,V> {
	protected int n = 0;
	protected int capacity;
	private int prime;
	private long scale, shift;
	
	public AbstractHashMap(int cap, int p){
		prime = p;
		capacity = cap;
		Random rand = new Random();
		scale = rand.nextInt(prime -1) + 1;
		shift = rand.nextInt(prime);
		createTable();
	}
	
	public AbstractHashMap(int cap){
		this(cap, 109345121);
	}
	public AbstractHashMap(){
		this(17);
	}
	
	private int hashValue(K key){
		return (int) ((Math.abs(key.hashCode()*scale + shift) % prime)%capacity);
	}
	
	private void resize(int newCap){
		ArrayList<Entry<K,V>> buffer = new ArrayList<>(n);
		for(Entry<K,V> e: entrySet())
			buffer.add(e);
		capacity = newCap;
		createTable();
		n = 0;
		for(Entry<K,V> e : buffer)
			put(e.getKey(), e.getValue());
	}

	public V get(Object key) {
		return bucketGet(hashValue((K)key), (K)key);
	}
	
	public V put(K key, V value) {
		V answer = bucketPut(hashValue(key), key, value);
		if(n > capacity / 2){
			resize(2 * capacity - 1);
		}
		return answer;
	}
	
	public V remove(Object key) {
		return bucketRemove(hashValue((K)key), (K)key);
	}

	public int size() {
		return n;
	}
	
	protected abstract void createTable();
	protected abstract V bucketGet(int h, K k);
	protected abstract V bucketPut(int h, K k, V v);
	protected abstract V bucketRemove(int h, K k);
	
}
