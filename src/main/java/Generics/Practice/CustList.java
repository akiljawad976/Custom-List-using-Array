package Generics.Practice;

import java.util.Arrays;
import java.util.Iterator;

public class CustList<T> {
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	private Object[] elements;

	public CustList() {
		elements = new Object[DEFAULT_CAPACITY];
	}

	public void add(T e) {
		if (size == elements.length) {
			ensureCapacity();
		}
		elements[size++] = e;
	}

	public void addAt(T e, int i) {
		if (size == elements.length) {
			ensureCapacity();
		}
		int index = ++size;
		while (index >= i) {
			elements[index] = elements[index - 1];
			index--;
		}
		elements[i] = e;

	}

	public T get(int i) {
		if (i >= size || i < 0) {
			throw new IndexOutOfBoundsException("ERROR in Get");
		} else {
			return (T) elements[i];
		}
	}

	public void removeAt(int i) {
		if (i >= size || i < 0) {
			throw new IndexOutOfBoundsException("ERROR is Remove");
		} else {
			while (i <= size - 1) {
				elements[i] = elements[i + 1];
				i++;
			}
			size--;
		}
		// return (T) elements;
	}

	public int size() {
		return size;
	}

	public void removeByBookName(String s) {
		String name = s.toString();
		Object[] results = elements;
		for (Object object : elements) {
			String bookName = ((Book) object).getBookName().toString();
			if (name.contentEquals(bookName)) {
				System.out.println(bookName);
				break;
			} else {
				continue;
			}
		}
	}

	public void removeByObject(T obj) {
//		for (int i = 0; i < size; i++) {
//			if (obj.equals((T) elements[i])) {
//				removeAt(i);
//			}
//		}
		removeAt(search(obj));
	}

	public int search(T obj) {
		for (int i = 0; i < size; i++) {
			if (obj.equals((T) elements[i])) {
				return i;
			}
		}
		return -1;

	}

	public void replaceByObject(T existing, T replaceby) {
		elements[search(existing)] = replaceby;
	}

	public void removeFullList() {
		int i = 0;
		while(size>0) {
			removeAt(i);
			size--;
		}
	}
	public void addAll(CustList<T> obj) {
		ensureCapacity();
		int j = 0;
		for(int i = size;i<this.size+obj.size;i++) {
			elements[i]=obj.elements[j];
			j++;
		}
		size = size+obj.size;
	}
	public void removeAll(CustList<T> obj) {
		for(int i=0;i<obj.size;i++) {
			int index = search(obj.get(i));
			if(index==-1) {
				continue;
			}else {
				removeAt(index);
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < size; i++) {
			sb.append(elements[i].toString());
			if (i < size - 1) {
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public void ensureCapacity() {
		int newsize = elements.length * 2;
		elements = Arrays.copyOf(elements, newsize);
	}
}
