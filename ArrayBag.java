
public final class ArrayBag<T> implements BagInterface<T> {

	private final T[] bag; //type is final values can still be changed
	private int numberOfEntries;
	private boolean initialized = false; //for security
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAXIMUM_CAPACITY = 10000; //for reliability
	
	public ArrayBag(){
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayBag(int desiredCapacity){
		if(desiredCapacity<MAXIMUM_CAPACITY){
		@SuppressWarnings("unchecked")
		T[] tempBag=(T[]) new Object[desiredCapacity]; //Unchecked cast, object - stack & 'new'- dynamic data 
		bag=tempBag;
		numberOfEntries=0;
		initialized=true;
		}else
			throw new IllegalStateException("Attempt to create a bag "+"whose capacity exceeds "+"allowed maximum");
		//initialized=true;
	}
	/*set truth(assertions)
	 * 1. all items added in consecution order
	 * 2. if arrayfull return false
	 * 3. if array not full, add item and increment index
	*/
	@Override
	public boolean add(T newEntry) {
		checkInitialization();
		// TODO Auto-generated method stub
		boolean result =true;
		if(isArrayFull()){
			result=false;
		}else{
			bag[numberOfEntries]=newEntry;
			numberOfEntries++;
		}
		
		return result;
	}

	private void checkInitialization() {
		// TODO Auto-generated method stub
		if(!initialized)
			throw new SecurityException("ArrayBag object is not initialized properly");
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		for(int index=0;index<numberOfEntries;index++){
			result[index]=bag[index];
		}
		return result;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(T newEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	
	private boolean isArrayFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T newEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
