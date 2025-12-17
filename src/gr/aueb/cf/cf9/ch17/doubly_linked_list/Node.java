package gr.aueb.cf.cf9.ch17.doubly_linked_list;

public class Node<T> {

    private T item;
    private Node<T> prev;
    private Node<T> next;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
