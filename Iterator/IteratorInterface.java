package Iterator;

public interface IteratorInterface<T> {
	public boolean hasNext();
	public T next();
	public void remove();

}