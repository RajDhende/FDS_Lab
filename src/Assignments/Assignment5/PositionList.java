package Assignments.Assignment5;

import java.util.Iterator;

/**
 * The Position interface represents a position in a positional list.
 *
 * @param <E> The type of element stored in the position.
 */
interface Position<E> {
    /**
     * Get the element stored in this position.
     *
     * @return The element stored in the position.
     */
    E getElement();
}

/**
 * The PositionalList interface defines a list with positional access to its elements.
 *
 * @param <E> The type of element stored in the list.
 */
interface PositionalList<E> {
    int size();

    boolean isEmpty();

    Position<E> first();

    Position<E> last();

    Position<E> before(Position<E> p);

    Position<E> after(Position<E> p);

    Position<E> addFirst(E e);

    Position<E> addLast(E e);

    Position<E> addBefore(Position<E> p, E e);

    Position<E> addAfter(Position<E> p, E e);

    E set(Position<E> p, E e);

    E remove(Position<E> p);

    Iterable<Position<E>> positions();
}

/**
 * The Node class represents a node in a doubly-linked list.
 *
 * @param <E> The type of element stored in the node.
 */
class Node<E> implements Position<E> {
    public E element;
    private Node<E> prev;
    private Node<E> next;

    /**
     * Constructs a node with the given element, previous node, and next node.
     *
     * @param element The element to be stored in the node.
     * @param prev    The previous node in the list.
     * @param next    The next node in the list.
     */
    public Node(E element, Node<E> prev, Node<E> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}

/**
 * The PositionalLinkedList class implements the PositionalList interface using a doubly-linked list.
 *
 * @param <E> The type of element stored in the list.
 */
class PositionalLinkedList<E> implements PositionalList<E> {
    private Node<E> header;
    private Node<E> trailer;
    private int size;

    /**
     * Constructs an empty positional linked list with a header and trailer sentinel nodes.
     */
    public PositionalLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
        size = 0;
    }

    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Invalid position");
        }
        Node<E> node = (Node<E>) p;
        if (node.getNext() == null) {
            throw new IllegalArgumentException("Position is no longer in the list.");
        }
        return node;
    }

    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer) {
            return null;
        }
        return node;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Position<E> first() {
        return position(header.getNext());
    }

    public Position<E> last() {
        return position(trailer.getPrev());
    }

    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    public Position<E> addFirst(E e) {
        Node<E> newNode = new Node<>(e, header, header.getNext());
        header.getNext().setPrev(newNode);
        header.setNext(newNode);
        size++;
        return newNode;
    }

    public Position<E> addLast(E e) {
        Node<E> newNode = new Node<>(e, trailer.getPrev(), trailer);
        trailer.getPrev().setNext(newNode);
        trailer.setPrev(newNode);
        size++;
        return newNode;
    }

    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> newNode = new Node<>(e, node.getPrev(), node);
        node.getPrev().setNext(newNode);
        node.setPrev(newNode);
        size++;
        return newNode;
    }

    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> newNode = new Node<>(e, node, node.getNext());
        node.getNext().setPrev(newNode);
        node.setNext(newNode);
        size++;
        return newNode;
    }

    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E oldValue = node.getElement();
        ((Node<E>) node).element = e;
        return oldValue;
    }

    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> prevNode = node.getPrev();
        Node<E> nextNode = node.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        node.setPrev(null);
        node.setNext(null);
        E removedElement = node.getElement();
        size--;
        return removedElement;
    }

    public Iterable<Position<E>> positions() {
        return new PositionIterable();
    }

    private class PositionIterator implements Iterator<Position<E>> {
        private Position<E> cursor = first();

        public boolean hasNext() {
            return cursor != null;
        }

        public Position<E> next() {
            if (cursor == null) {
                throw new IllegalArgumentException("No more positions.");
            }
            Position<E> current = cursor;
            cursor = after(cursor);
            return current;
        }
    }

    private class PositionIterable implements Iterable<Position<E>> {
        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }
    }
}
