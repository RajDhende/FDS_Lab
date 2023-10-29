package Assignments.Assignment5;
/**
 * An interface representing a list of positions, where each position contains an element of type E.
 *
 * @param <E> The type of elements stored in the list.
 */
public interface PositionList<E> {

    /**
     * Returns the number of elements in the list.
     *
     * @return The number of elements in the list.
     */
    int size();

    /**
     * Tests whether the list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the first Position in the list (or null if empty).
     *
     * @return The first position in the list, or null if the list is empty.
     */
    Position<E> first();

    /**
     * Returns the last Position in the list (or null if empty).
     *
     * @return The last position in the list, or null if the list is empty.
     */
    Position<E> last();

    /**
     * Returns the Position immediately before Position p (or null if p is the first).
     *
     * @param p The position for which to find the one immediately before.
     * @return The position before p, or null if p is the first.
     * @throws IllegalArgumentException if p is not a valid position in this list.
     */
    Position<E> before(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the Position immediately after Position p (or null if p is the last).
     *
     * @param p The position for which to find the one immediately after.
     * @return The position after p, or null if p is the last.
     * @throws IllegalArgumentException if p is not a valid position in this list.
     */
    Position<E> after(Position<E> p) throws IllegalArgumentException;

    /**
     * Inserts element e at the front of the list and returns its new Position.
     *
     * @param e The element to insert at the front of the list.
     * @return The new Position where the element is inserted.
     */
    Position<E> addFirst(E e);

    /**
     * Inserts element e at the back of the list and returns its new Position.
     *
     * @param e The element to insert at the back of the list.
     * @return The new Position where the element is inserted.
     */
    Position<E> addLast(E e);

    /**
     * Inserts element e immediately before Position p and returns its new Position.
     *
     * @param p The position before which to insert the new element.
     * @param e The element to insert.
     * @return The new Position where the element is inserted.
     * @throws IllegalArgumentException if p is not a valid position in this list.
     */
    Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Inserts element e immediately after Position p and returns its new Position.
     *
     * @param p The position after which to insert the new element.
     * @param e The element to insert.
     * @return The new Position where the element is inserted.
     * @throws IllegalArgumentException if p is not a valid position in this list.
     */
    Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Replaces the element stored at Position p and returns the replaced element.
     *
     * @param p The position whose element is to be replaced.
     * @param e The new element to store at Position p.
     * @return The element that was previously stored at Position p.
     * @throws IllegalArgumentException if p is not a valid position in this list.
     */
    E set(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Removes the element stored at Position p and returns it (invalidating p).
     *
     * @param p The position from which to remove the element.
     * @return The element that was removed from Position p.
     * @throws IllegalArgumentException if p is not a valid position in this list.
     */
    E remove(Position<E> p) throws IllegalArgumentException;
}
