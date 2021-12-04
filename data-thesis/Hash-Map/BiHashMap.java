package it.angeloavv.bihashmap;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Bi-directional hash table nearly-based implementation of the Map interface. 
 * This implementation provides most of all of the optional map operations, and permits null values and the null key. (The BiHashMap class is roughly equivalent to Hashtable, except that it is unsynchronized and permits nulls.) 
 * This class makes no guarantees as to the order of the map; in particular, it does not guarantee that the order will remain constant over time.
 * The advantage of using this particular implementation allows the user to access data from both the directions, either by key or by value.
 * 
 * @author AngeloAvv
 * @version 1.0
 * @see <a href="https://github.com/AngeloAvv">AngeloAvv on GitHub</a>
 * @see <a href="http://www.mylittlesuite.com">MyLittleSuite</a>
 * 
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class BiHashMap<K, V> implements BHM<K, V>, Cloneable, Serializable {
	
	private static final long serialVersionUID = -2346574990449185372L;
	private HashMap<K, V> left;
	private HashMap<V, K> right;
	
	/**
	 * Constructs an empty BiHashMap with the default initial capacity (16) and the default load factor (0.75).
	 */
	public BiHashMap() {
		left = new HashMap<K, V>();
		right = new HashMap<V, K>();
	}
	
	/**
	 * Constructs an empty BiHashMap with the specified initial capacity and the default load factor (0.75).
	 * @param initialCapacity the initial capacity.
	 */
	public BiHashMap(int initialCapacity) {
		left = new HashMap<K, V>(initialCapacity);
		right = new HashMap<V, K>(initialCapacity);
	}
	
	/**
	 * Constructs an empty BiHashMap with the specified initial capacity and load factor.
	 * @param initialCapacity the initial capacity
	 * @param loadFactor the load factor
	 */
	public BiHashMap(int initialCapacity, float loadFactor) {
		left = new HashMap<K, V>(initialCapacity, loadFactor);
		right = new HashMap<V, K>(initialCapacity, loadFactor);
	}

	/* (non-Javadoc)
	 * @see it.angeloavv.bihashmap.BHM#size()
	 */
	@Override
	public int size() {
		if (isNull()) throw new NullPointerException();
		
		return left.size();
	}

	/* (non-Javadoc)
	 * @see it.angeloavv.bihashmap.BHM#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		if (isNull()) throw new NullPointerException();
		
		return left.isEmpty();
	}

	/* (non-Javadoc)
	 * @see it.angeloavv.bihashmap.BHM#containsByKey(java.lang.Object)
	 */
	@Override
	public boolean containsByKey(K key) {
		if (isNull()) throw new NullPointerException();
		
		return left.containsKey(key);
	}
	
	/* (non-Javadoc)
	 * @see it.angeloavv.bihashmap.BHM#containsByValue(java.lang.Object)
	 */
	@Override
	public boolean containsByValue(V value) {
		if (isNull()) throw new NullPointerException();
		
		return right.containsKey(value);
	}
	
	/* (non-Javadoc)
	 * @see it.angeloavv.bihashmap.BHM#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(Object key) {
		if (isNull()) throw new NullPointerException();
		
		return left.containsKey(key) || right.containsKey(key);
	}

	/* (non-Javadoc)
	 * @see it.angeloavv.bihashmap.BHM#getKeyByValue(java.lang.Object)
	 */
	@Override
	public K getKeyByValue(V value) {
		if (isNull()) throw new NullPointerException();
		
		return right.get(value);
	}
	
	/* (non-Javadoc)
	 * @see it.angeloavv.bihashmap.BHM#getValueByKey(java.lang.Object)
	 */
	@Override
	public V getValueByKey(K key) {
		if (isNull()) throw new NullPointerException();
		
		return left.get(key);
	}

	/* (non-Javadoc)
	 * @see it.angeloavv.bihashmap.BHM#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V put(K key, V value) {
		if (isNull()) throw new NullPointerException();
		
		left.put(key, value);
		right.put(value, key);
		
		return value;
	}

	/* (non-Javadoc)
	 * @see it.angeloavv.bihashmap.BHM#removeByKey(java.lang.Object)
	 */
	@Override
	public K removeByKey(K key) {
		if (isNull()) throw new NullPointerException();
		
		return right.remove(left.remove(key));
	}
	
	/* (non-Javadoc)
	 * @see it.angeloavv.bihashmap.BHM#removeByValue(java.lang.Object)
	 */
	@Override
	public V removeByValue(V value) {
		if (isNull()) throw new NullPointerException();
		
		return left.remove(right.remove(value));
	}

	/* (non-Javadoc)
	 * @see it.angeloavv.bihashmap.BHM#putAllByKey(java.util.Map)
	 */
	@Override
	public void putAllByKey(Map<? extends K, ? extends V> m) {
		if (isNull()) throw new NullPointerException();
		
		for(K key : m.keySet()) {
			left.put(key, m.get(key));
			right.put(m.get(key), key);
		}
	}
	
	/* (non-Javadoc)
	 * @see it.angeloavv.bihashmap.BHM#putAllByValue(java.util.Map)
	 */
	@Override
	public void putAllByValue(Map<? extends V, ? extends K> m) {
		if (isNull()) throw new NullPointerException();
		
		for(V key : m.keySet()) {
			left.put(m.get(key), key);
			right.put(key, m.get(key));
		}
	}

	/* (non-Javadoc)
	 * @see it.angeloavv.bihashmap.BHM#clear()
	 */
	@Override
	public void clear() {
		if (isNull()) throw new NullPointerException();
		
		left.clear();
		right.clear();
	}

	/* (non-Javadoc)
	 * @see it.angeloavv.bihashmap.BHM#keySetByKey()
	 */
	@Override
	public Set<K> keySetByKey() {
		if (isNull()) throw new NullPointerException();
		
		return left.keySet();
	}
	
	/* (non-Javadoc)
	 * @see it.angeloavv.bihashmap.BHM#keySetByValue()
	 */
	@Override
	public Set<V> keySetByValue() {
		if (isNull()) throw new NullPointerException();
		
		return right.keySet();
	}

	/* (non-Javadoc)
	 * @see it.angeloavv.bihashmap.BHM#valuesByKey()
	 */
	@Override
	public Collection<K> valuesByKey() {
		if (isNull()) throw new NullPointerException();
		
		return right.values();
	}
	
	/* (non-Javadoc)
	 * @see it.angeloavv.bihashmap.BHM#valuesByValue()
	 */
	@Override
	public Collection<V> valuesByValue() {
		if (isNull()) throw new NullPointerException();
		
		return left.values();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BiHashMap other = (BiHashMap) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "BiHashMap [left=" + left + ", right=" + right + "]";
	}

	private boolean isNull() {
		return left == null && right == null;
	}

}
