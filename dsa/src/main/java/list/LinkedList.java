package list;
public class LinkedList<T> {
    private int length;
    private Node<T> head;
    private Node<T> tail;

    public LinkedList(T value) {
        this.head = this.tail = null;
        this.length = 0;
    }

    public void prepend(T item) {
        this.length += 1;
        Node<T> node = new Node<T>(item);
        if(this.head == null) {
           this.head = this.tail = node;
           return;
        }
        node.next = this.head;
        this.head = node;
    }

    public void append(T item) {
        Node<T> node = new Node<T>(item);
        if (this.head == null || this.tail == null) {
            this.head = this.tail = node;
            return;
        }
        this.tail.next = node;
        this.tail = node;

        this.length += 1;
    }
}
