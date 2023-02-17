package hw;

public interface StackInterface<E> {
	void push(E e);
	E pop();
	E peek();
	boolean isFull();
	boolean isEmpty();
}