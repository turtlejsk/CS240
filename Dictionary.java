package Dictionary;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Dictionary<K, V> implements DictionaryInterface<K, V> {

	private Entry<K, V>[] dictionary;
	private int numberOfEntries;
	private boolean initialized = false;
	private final static int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 1000;

	public Dictionary() {
		this(DEFAULT_CAPACITY);
	}

	public Dictionary(int initialCapacity) {
		checkCapacity(initialCapacity);
		@SuppressWarnings("unchecked")
		Entry<K, V>[] tempDictionary = (Entry<K, V>[]) new Entry[initialCapacity];
		dictionary = tempDictionary;
		numberOfEntries = 0;
		initialized = true;
	}

	private void checkCapacity(int capacity) {
		if (capacity > DEFAULT_CAPACITY)
			throw new IllegalStateException("Capacity exceeds maximum capacity.");
	} // end checkCapacity

	private void checkInitialization() {
		if (!initialized)
			throw new SecurityException("Dictionary is not initialized properly.");
	} // end checkInitialization

	@Override
	public V add(K key, V value) {
		checkInitialization();
		if ((key == null) || (value == null))
			throw new IllegalArgumentException();
		else {
			V result = null;
			int keyIndex = find(key);
			if (keyIndex < numberOfEntries) {
				result = dictionary[keyIndex].getValue();
				dictionary[keyIndex].setValue(value);
			} else {
				dictionary[numberOfEntries] = new Entry<>(key, value);
				numberOfEntries++;
				// ensureCapacity();
			}
			return result;
		}
	}

	private int find(K key) {
		int index = 0;

		for (int i = 0; i < numberOfEntries; i++) {
			if (dictionary[i].getKey() == key) {
				index = i;
			}
		}

		return index;
	}

	@Override
	public V remove(K key) {
		checkInitialization();
		V result = null;
		int keyIndex = find(key);
		if (keyIndex < numberOfEntries) {
			result = dictionary[keyIndex].getValue();
			dictionary[keyIndex] = dictionary[numberOfEntries - 1];
			dictionary[numberOfEntries - 1] = null;
			numberOfEntries--;
		}
		return result;
	}

	@Override
	public V getValue(K key) {
		int keyIndex = find(key);
		return dictionary[keyIndex].getValue();
	}

	@Override
	public boolean contains(K key) {
		return dictionary[find(key)].getKey() == key;
	}

	@Override
	public Iterator<K> getKeyIterator() {
		return new KeyIterator();
	}

	@Override
	public Iterator<V> getValueIterator() {
		return new ValueIterator();
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries <= 0;
	}

	@Override
	public int getSize() {
		return numberOfEntries;
	}

	@Override
	public void clear() {
		while (!isEmpty()) {
			dictionary[numberOfEntries - 1].setValue(null);
			numberOfEntries--;
		}
	}

	private class ValueIterator implements Iterator<V> {
		private int nextIndex;

		private ValueIterator() {
			nextIndex = 0;

		}

		@Override
		public boolean hasNext() {
			return nextIndex < numberOfEntries;
		}

		@Override
		public V next() {
			if (hasNext()) {

				V nextEntry = dictionary[nextIndex].getValue();
				nextIndex++;
				return nextEntry;
			} else {
				throw new NoSuchElementException("Illegal call to next(); " + "iterator is after end of list.");
			}
		}

		@Override
		public void remove() {

			dictionary[nextIndex].setValue(null);
			nextIndex--;

		}
	}

	private class KeyIterator implements Iterator<K> {
		private int nextIndex;

		private KeyIterator() {
			nextIndex = 0;

		}

		@Override
		public boolean hasNext() {
			return nextIndex < numberOfEntries;
		}

		@Override
		public K next() {
			if (hasNext()) {

				K nextEntry = dictionary[nextIndex].getKey();
				nextIndex++;
				return nextEntry;
			} else {
				throw new NoSuchElementException("Illegal call to next(); " + "iterator is after end of list.");
			}
		}

		@Override
		public void remove() {
			Dictionary.this.remove(dictionary[nextIndex].getKey());
		}
	} // end KeyIteratorForDictionary

	private class Entry<S, T> {
		private S key;
		private T value;

		private Entry(S searchKey, T dataValue) {
			key = searchKey;
			value = dataValue;
		}

		private S getKey() {
			return key;
		}

		private T getValue() {
			return value;
		}

		private void setValue(T newValue) {
			value = newValue;
		}
	}

}