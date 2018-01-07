package lollipop.core.array;

public class SimpleArray<T> {
	
	private Object[] _a;
	
	private int size;
	
	private int capacity;
	
	private static final int DEFAULT_CAPACITY = 10;
	
	public SimpleArray() {
		this.capacity = DEFAULT_CAPACITY;
		this._a = new Object[this.capacity];
	}
	
	public SimpleArray(int capacity) {
		this.capacity = capacity;
		this._a = new Object[this.capacity];
	}
	
	public T get(int i) {
		if(i < 0 || i >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		@SuppressWarnings("unchecked")
		final T a = (T)_a[i];
		return a;
	}
	
	public void set(int i, T elem) {
		if(i < 0 || i >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		_a[i] = elem;
	}
	
	public void pushBack(T elem) {
		if(size == capacity) {
			Object[] _a_new = new Object[capacity*2];
			for(int i=0; i<size-1; ++i) {
				_a_new[i] = _a[i];
			}
			_a = _a_new;
			capacity = capacity*2;
		}
		_a[size] = elem;
		size = size+1;
	}
	
	public void remove(int i) {
		if(i < 0 || i >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		for(int j=i; j < size-1; ++j) {
			_a[j] = _a[j+1];
		}
		size = size-1;
	}
	
	public int size() {
		return size;
	}

}
