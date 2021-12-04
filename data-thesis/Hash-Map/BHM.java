package it.angeloavv.bihashmap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;


public interface BHM<K, V> {
	
	/**
	 * Returns the number of key-value mappings in this map.
	 * @return the number of key-value mappings in this map
	 */
	public int size();
	
	/**
	 * Returns true if this map contains no key-value mappings.
	 * @return true if this map contains no key-value mappings
	 */
	public boolean isEmpty();
	
	/**
	 * Returns true if this map contains a mapping for the specified key.
	 * @param key The key whose presence in this map is to be tested
	 * @return true if this map contains a mapping for the specified key.
	 */
	public boolean containsByKey(K key);
	
	/**
	 * Returns true if this map contains a mapping for the specified value.
	 * @param value The value whose presence in this map is to be tested
	 * @return true if this map contains a mapping for the specified value.
	 */
	public boolean containsByValue(V value);
	
	/**
	 * Returns true if this map contains a mapping for either the specified key or value.
	 * @param key The object whose presence in this map is to be tested
	 * @return true if this map contains a mapping for the specified key or value.
	 */
	public boolean contains(Object key);
	
	/**
	 * Returns the key to which the specified value is mapped, or null if this map contains no mapping for the value.
	 * More formally, if this map contains a mapping from a value v to a key k such that (value==null ? v==null : value.equals(v)), then this method returns k; otherwise it returns null. (There can be at most one such mapping.)
	 * A return key of null does not necessarily indicate that the map contains no mapping for the value; it's also possible that the map explicitly maps the value to null. The containsByValuey operation may be used to distinguish these two cases.
	 * @param value the value whose associated key is to be returned
	 * @return the key to which the specified value is mapped, or null if this map contains no mapping for the value
	 */
	public K getKeyByValue(V value);
	
	/**
	 * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
	 * More formally, if this map contains a mapping from a key k to a value v such that (key==null ? k==null : key.equals(k)), then this method returns v; otherwise it returns null. (There can be at most one such mapping.)
	 * A return value of null does not necessarily indicate that the map contains no mapping for the key; it's also possible that the map explicitly maps the key to null. The containsByKey operation may be used to distinguish these two cases.
	 * @param key the key whose associated value is to be returned
	 * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key
	 */
	public V getValueByKey(K key);
	
	/**
	 * Associates the specified value with the specified key in this map. If the map previously contained a mapping for the key, the old value is replaced.
	 * @param key key with which the specified value is to be associated
	 * @param value value to be associated with the specified key
	 * @return the previous value associated with key, or null if there was no mapping for key. (A null return can also indicate that the map previously associated null with key.)
	 */
	public V put(K key, V value);
	
	/**
	 * Removes the mapping for the specified key from this map if present.
	 * @param key key whose mapping is to be removed from the map
	 * @return the previous value associated with key, or null if there was no mapping for key. (A null return can also indicate that the map previously associated null with key.)
	 */
	public K removeByKey(K key);
	
	/**
	 * Removes the mapping for the specified value from this map if present.
	 * @param value value whose mapping is to be removed from the map
	 * @return the previous key associated with value, or null if there was no mapping for value. (A null return can also indicate that the map previously associated null with value.)
	 */
	public V removeByValue(V value);
	
	/**
	 * Copies all of the mappings from the specified map to this map. These mappings will replace any mappings that this map had for any of the keys currently in the specified map.
	 * @param m mappings to be stored in this map
	 */
	public void putAllByKey(Map<? extends K, ? extends V> m);	
	
	/**
	 * Copies all of the mappings from the specified map to this map. These mappings will replace any mappings that this map had for any of the values currently in the specified map.
	 * @param m mappings to be stored in this map
	 */
	public void putAllByValue(Map<? extends V, ? extends K> m);
	
	/**
	 * Removes all of the mappings from this map. The map will be empty after this call returns.
	 */
	public void clear();
	
	/**
	 * Returns a Set view of the keys contained in this map. 
	 * The set is backed by the map, so changes to the map are reflected in the set, and vice-versa. 
	 * If the map is modified while an iteration over the set is in progress (except through the iterator's own remove operation), the results of the iteration are undefined. 
	 * The set supports element removal, which removes the corresponding mapping from the map, via the Iterator.remove, Set.remove, removeAll, retainAll, and clear operations. 
	 * It does not support the add or addAll operations.
	 * @return a set view of the keys contained in this map
	 */
	public Set<K> keySetByKey();
	
	/**
	 * Returns a Set view of the values contained in this map. 
	 * The set is backed by the map, so changes to the map are reflected in the set, and vice-versa. 
	 * If the map is modified while an iteration over the set is in progress (except through the iterator's own remove operation), the results of the iteration are undefined. 
	 * The set supports element removal, which removes the corresponding mapping from the map, via the Iterator.remove, Set.remove, removeAll, retainAll, and clear operations. 
	 * It does not support the add or addAll operations.
	 * @return a set view of the keys contained in this map
	 */
	public Set<V> keySetByValue();
	
	/**
	 * Returns a Collection view of the keys contained in this map. The collection is backed by the map, so changes to the map are reflected in the collection, and vice-versa. If the map is modified while an iteration over the collection is in progress (except through the iterator's own remove operation), the results of the iteration are undefined. The collection supports element removal, which removes the corresponding mapping from the map, via the Iterator.remove, Collection.remove, removeAll, retainAll and clear operations. It does not support the add or addAll operations.
	 * @return a set view of the mappings contained in this map
	 */
	public Collection<K> valuesByKey();
	
	/**
	 * Returns a Collection view of the values contained in this map. The collection is backed by the map, so changes to the map are reflected in the collection, and vice-versa. If the map is modified while an iteration over the collection is in progress (except through the iterator's own remove operation), the results of the iteration are undefined. The collection supports element removal, which removes the corresponding mapping from the map, via the Iterator.remove, Collection.remove, removeAll, retainAll and clear operations. It does not support the add or addAll operations.
	 * @return a set view of the mappings contained in this map
	 */
	public Collection<V> valuesByValue();
}
