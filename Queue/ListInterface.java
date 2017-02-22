/**
   An interface for the ADT List.
   @author Junsung Kim
*/
public interface ListInterface<T>
{
  /** Adds a new entry to the back of this list.
      @param newEntry  An object to be added. */
  public void add(T newEntry);
  
    /** Adds a new entry to the certain position of this list.
      @param newEntry  An object to be added and index to add. */
  public void addTo(T newEntry, int index);
  
  
  /** Removes and returns the entry at the given index of this list.
      @return  The object at the given index of the list. 
      @throws  EmptyListException if the queue is empty before the operation. */
  public T remove(int index);
  
   /** Removes all entries from this queue. */
  public void removeAll();
  
  /**  Retrieves the entry at the given index of this list.
      @return  The object at the given index of the list.
      @throws  EmptyListException if the list is empty. */
  public T check(int index);
  
  /**  Retrieves array of entries of this list.
      @return  The array of entries of the list.
      @throws  EmptyListException if the list is empty. */
  public T[] checkAll();
  
  /** Detects whether the certain value exists in this list.
	  @return True if the list has the value, of false otherwise. */
  public isExist(T newEntry);
  
  /** Detects whether this list is empty.
      @return  True if the list is empty, or false otherwise. */
  public boolean isEmpty();
  
  /**  Retrieves the size of this list.
      @return  The size value of the list. */
  public int count();

} // end ListInterface
