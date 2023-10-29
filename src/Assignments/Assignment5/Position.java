package Assignments.Assignment5;

/**
 * A Position represents a specific element within a data structure.
 * It provides a method to retrieve the element contained at that position.
 *
 * @param <E> The type of element stored in the Position.
 */
public interface Position<E> {

    /**
     * Returns the element stored at this position.
     *
     * @return The element at this position.
     * @throws IllegalStateException if the position is invalid or the element is no longer available.
     */
    E getElement( ) throws IllegalStateException;
}
