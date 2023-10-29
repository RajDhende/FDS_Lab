package Assignments.Assignment5;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Implementation of a positional list stored as a doubly linked list.
 *
 * @param <E> The type of elements in the list.
 */
public class LinkedPositionalList<E> implements PositionList<E> {
    //---------------- nested Node class ----------------
    /**
     * Nested class representing a node in the doubly linked list.
     *
     * @param <E> The type of element stored in the node.
     */
    private static class Node<E> implements Position<E> {
        private E element; // Reference to the element stored at this node
        private Node<E> prev; // Reference to the previous node in the list
        private Node<E> next; // Reference to the subsequent node in the list

        /**
         * Constructs a new node with the provided element, previous, and next references.
         */
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        /**
         * Returns the element stored at this node.
         *
         * @return The element at this position.
         * @throws IllegalStateException if the node is no longer valid.
         */
        public E getElement() throws IllegalStateException {
            if (next == null) // Convention for a defunct node
                throw new IllegalStateException("Position no longer valid");
            return element;
        }

        /**
         * Returns the previous node in the list.
         *
         * @return The previous node in the list.
         */
        public Node<E> getPrev() {
            return prev;
        }

        /**
         * Returns the next node in the list.
         *
         * @return The next node in the list.
         */
        public Node<E> getNext() {
            return next;
        }

        /**
         * Sets the element stored at this node.
         *
         * @param e The new element to set.
         */
        public void setElement(E e) {
            element = e;
        }

        /**
         * Sets the previous node in the list.
         *
         * @param p The new previous node.
         */
        public void setPrev(Node<E> p) {
            prev = p;
        }

        /**
         * Sets the next node in the list.
         *
         * @param n The new next node.
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    } //----------- end of nested Node class -----------

    // instance variables of the LinkedPositionalList
    private Node<E> header; // Header sentinel
    private Node<E> trailer; // Trailer sentinel
    private int size = 0; // Number of elements in the list

    /**
     * Constructs a new empty list with header and trailer sentinels.
     */
    public LinkedPositionalList() {
        header = new Node<>(null, null, null); // Create header
        trailer = new Node<>(null, header, null); // Trailer is preceded by header
        header.setNext(trailer); // Header is followed by trailer
    }

    /**
     * Validates the position and returns it as a node.
     *
     * @param p The position to validate.
     * @return The validated node corresponding to the position.
     * @throws IllegalArgumentException if the position is invalid.
     */
    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Invalid p");
        Node<E> node = (Node<E>) p; // Safe cast
        if (node.getNext() == null) // Convention for a defunct node
            throw new IllegalArgumentException("p is no longer in the list");
        return node;
    }

    /**
     * Returns the given node as a Position (or null, if it is a sentinel).
     *
     * @param node The node to convert to a Position.
     * @return The Position represented by the node.
     */
    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer)
            return null; // Do not expose the user to the sentinels
        return node;
    }

    /**
     * Returns the number of elements in the linked list.
     *
     * @return The number of elements in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Tests whether the linked list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the first Position in the linked list (or null, if empty).
     *
     * @return The first position in the list, or null if the list is empty.
     */
    public Position<E> first() {
        return position(header.getNext());
    }

    /**
     * Returns the last Position in the linked list (or null, if empty).
     *
     * @return The last position in the list, or null if the list is empty.
     */
    public Position<E> last() {
        return position(trailer.getPrev());
    }

    /**
     * Returns the Position immediately before Position p (or null, if p is first).
     *
     * @param p The position for which to find the one immediately before.
     * @return The position before p, or null if p is the first.
     * @throws IllegalArgumentException if p is not a valid position in this list.
     */
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    /**
     * Returns the Position immediately after Position p (or null, if p is last).
     *
     * @param p The position for which to find the one immediately after.
     * @return The position after p, or null if p is the last.
     * @throws IllegalArgumentException if p is not a valid position in this list.
     */
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    /**
     * Adds element e to the linked list between the given nodes.
     *
     * @param e    The element to add to the list.
     * @param pred The node before which to add the new element.
     * @param succ The node after which to add the new element.
     * @return The new Position where the element is inserted.
     */
    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node<>(e, pred, succ); // Create and link a new node
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }

    /**
     * Inserts element e at the front of the linked list and returns its new Position.
     *
     * @param e The element to insert at the front of the list.
     * @return The new Position where the element is inserted.
     */
    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext()); // Just after the header
    }

    /**
     * Inserts element e at the back of the linked list and returns its new Position.
     *
     * @param e The element to insert at the back of the list.
     * @return The new Position where the element is inserted.
     */
    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer); // Just before the trailer
    }

    /**
     * Inserts element e immediately before Position p and returns its new Position.
     *
     * @param p The position before which to insert the new element.
     * @param e The element to insert.
     * @return The new Position where the element is inserted.
     * @throws IllegalArgumentException if p is not a valid position in this list.
     */
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    /**
     * Inserts element e immediately after Position p and returns its new Position.
     *
     * @param p The position after which to insert the new element.
     * @param e The element to insert.
     * @return The new Position where the element is inserted.
     * @throws IllegalArgumentException if p is not a valid position in this list.
     */
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    /**
     * Replaces the element stored at Position p and returns the replaced element.
     *
     * @param p The position whose element is to be replaced.
     * @param e The new element to store at Position p.
     * @return The element that was previously stored at Position p.
     * @throws IllegalArgumentException if p is not a valid position in this list.
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }

    /**
     * Removes the element stored at Position p and returns it (invalidating p).
     *
     * @param p The position from which to remove the element.
     * @return The element that was removed from Position p.
     * @throws IllegalArgumentException if p is not a valid position in this list.
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        E answer = node.getElement();
        node.setElement(null); // Help with garbage collection
        node.setNext(null); // And convention for a defunct node
        node.setPrev(null);
        return answer;
    }

    //---------------- nested PositionIterator class ----------------
    /**
     * Nested class representing an iterator for the positions in the list.
     */
    private class PositionIterator implements Iterator<Position<E>> {
        private Position<E> cursor = first(); // Position of the next element to report
        private Position<E> recent = null; // Position of the last reported element

        /**
         * Tests whether the iterator has a next object.
         *
         * @return true if there is a next position, false otherwise.
         */
        public boolean hasNext() {
            return (cursor != null);
        }

        /**
         * Returns the next position in the iterator.
         *
         * @return The next position.
         * @throws NoSuchElementException if there are no more positions to report.
         */
        public Position<E> next() throws NoSuchElementException {
            if (cursor == null) throw new NoSuchElementException("Nothing left");
            recent = cursor; // Element at this position might later be removed
            cursor = after(cursor);
            return recent;
        }

        /**
         * Removes the element returned by the most recent call to next.
         *
         * @throws IllegalStateException if there's nothing to remove.
         */
        public void remove() throws IllegalStateException {
            if (recent == null) throw new IllegalStateException("Nothing to remove");
            LinkedPositionalList.this.remove(recent); // Remove from the outer list
            recent = null; // Do not allow remove again until next is called
        }
    } //------------ end of nested PositionIterator class ------------

    //---------------- nested PositionIterable class ----------------
    /**
     * Nested class representing an iterable for the positions in the list.
     */
    private class PositionIterable implements Iterable<Position<E>> {
        /**
         * Returns an iterator for the positions in the list.
         *
         * @return An iterator for the positions.
         */
        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }
    } //------------ end of nested PositionIterable class ------------

    /**
     * Returns an iterable representation of the list's positions.
     *
     * @return An iterable for the positions in the list.
     */
    public Iterable<Position<E>> positions() {
        return new PositionIterable(); // Create a new instance of the inner class
    }

    //---------------- nested ElementIterator class ----------------
    /**
     * Nested class adapting the iteration produced by positions() to return elements.
     */
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = new PositionIterator();

        /**
         * Tests whether the iterator has a next element.
         *
         * @return true if there is a next element, false otherwise.
         */
        public boolean hasNext() {
            return posIterator.hasNext();
        }

        /**
         * Returns the next element in the iterator.
         *
         * @return The next element.
         */
        public E next() {
            return posIterator.next().getElement(); // Return element!
        }

        /**
         * Removes the element returned by the most recent call to next.
         */
        public void remove() {
            posIterator.remove();
        }
    }

    /**
     * Returns an iterator of the elements stored in the list.
     *
     * @return An iterator for the elements in the list.
     */
    public Iterator<E> iterator() {
        return new ElementIterator();
    }
}
