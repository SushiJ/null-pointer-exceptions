package LRUcache;

import java.util.HashMap;

class Node<T> {
    public T value;
    public Node<T> next;
    public Node<T> prev;

    public Node(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

public class LRU<K, V> {
    private int length;
    private Node<V> head;
    private Node<V> tail;

    private final int capacity;

    private final HashMap<K, Node<V>> lookUp;
    private final HashMap<Node<V>, K> reverseLookUp;

    public LRU() {
        this.capacity = 10;
        this.length = 0;
        this.head = this.tail = null;
        this.lookUp = new HashMap<>();
        this.reverseLookUp = new HashMap<>();
    }

    public LRU(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.head = this.tail = null;
        this.lookUp = new HashMap<>();
        this.reverseLookUp = new HashMap<>();
    }

    public void update(K key, V value) {
        Node<V> node = this.lookUp.get(key);
        if(node == null){
            this.length++;
            node = new Node<>(value);
            this.prepend(node);
            this.trimCache();

            this.lookUp.put(key, node);
            this.reverseLookUp.put(node, key);
        } else {
            node.value = value;
            this.detach(node);
            this.prepend(node);
        }
    }

    public V get(K key) {
        Node<V> node = this.lookUp.get(key);
        if(node == null) return null;

        this.detach(node);
        this.prepend(node);

        return node.value;
    }

    private void detach(Node<V> node) {
        if(node.next != null) {
            node.next.next = node.next;
        }

        if(node.prev != null){
            node.prev.next = node.next;
        }

        if(this.head == node) {
           this.head = this.head.next;
        }

        if(this.tail == node) {
            this.tail = this.tail.prev;
        }

        node.next = null;
        node.prev = null;
    }

    private void prepend(Node<V> node) {
        if(this.head == null) {
            this.head = this.tail = node;
            return;
        }
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
    }

    private void trimCache() {
        if(this.length <= this.capacity) {
            return;
        }
        Node<V> tail = this.tail;
        this.detach(tail);

        K key = this.reverseLookUp.get(tail);
        this.lookUp.remove(key);
        this.reverseLookUp.remove(tail);
        this.length--;
    }
}
