
package queue ;

/**
 * @author Benjamin Lauze
 * 
 * @version 1.0.0 2023-10-03 Initial implementation
 */
public interface QueueInterface<T>
    {

    public void enqueue( T newEntry ) ;

    public T dequeue() ; // Throws EmptyQueueException on empty queue

    public T getFront() ; // Throws EmptyQueueException on empty queue

    public boolean isEmpty() ;

    public void clear() ;

    }
// end class QueueInterface