
package queue ;

/**
 * @author Benjamin Lauze
 * 
 * @version 1.0.0 2023-10-05 Initial implementation
 */
public class ArrayQueue<T> implements QueueInterface<T>
    {

    private T[] queuearr ;
    private int capacity ;
    private static final int DEFAULT_CAPACITY = 10 ;
    private int frontIndex ;
    private int backIndex ;

    @SuppressWarnings( "unchecked" )
    public ArrayQueue( int capacity )
        {
        queuearr = (T[]) new Object[ capacity ] ;
        this.capacity = capacity ;
        frontIndex = 0 ;
        backIndex = capacity - 1 ;

        }


    public ArrayQueue()
        {
        this( DEFAULT_CAPACITY ) ;

        }


    public static void main( String[] args )
        {
        QueueInterface<String> animals = new ArrayQueue<>( 4 ) ;

        animals.enqueue( "dog" ) ;
        animals.enqueue( "cow" ) ;
        animals.enqueue( "sheep" ) ;
        System.out.println( "The first was " + animals.getFront() ) ;
        System.out.println( animals.dequeue() + " removed" ) ;
        animals.enqueue( "bull" ) ;
        animals.enqueue( "cat" ) ;

        QueueInterface<String> temp = new ArrayQueue<>( 4 ) ;
        while ( !animals.isEmpty() )
            {
            temp.enqueue( animals.dequeue() ) ;

            }

        while ( !temp.isEmpty() )
            {
            String s = temp.dequeue() ;
            System.out.print( s + " " ) ;
            animals.enqueue( s ) ;

            }

        System.out.println() ;

        }


    private boolean isFull()
        {
        return frontIndex == ( backIndex + 1 ) % capacity ;

        }


    private void doubleCapacity()
        {
        @SuppressWarnings( "unchecked" )
        T[] temp = (T[]) new Object[ 2 * capacity ] ;
        for ( int idx = 0 ; idx < capacity - 1 ; idx++ )
            {
            temp[ idx ] = queuearr[ ( frontIndex + idx ) % capacity ] ;

            }

        queuearr = temp ;
        frontIndex = 0 ;
        backIndex = capacity - 2 ;// capacity -1, and subtracting the front index 1
        capacity *= 2 ;

        }


    @Override
    public void enqueue( T newEntry )
        {
        backIndex = ( backIndex + 1 ) % capacity ;
        queuearr[ backIndex ] = newEntry ;
        if ( isFull() )
            {
            doubleCapacity() ;

            }

        }


    @Override
    public T dequeue()
        {
        if ( isEmpty() )
            {
            throw new EmptyQueueException( "No dequeue from empty queue!" ) ;

            }

        T outData = queuearr[ frontIndex ] ;
        queuearr[ frontIndex ] = null ;
        frontIndex = ( frontIndex + 1 ) % capacity ;
        return outData ;

        }


    @Override
    public T getFront()
        {
        if ( isEmpty() )
            {
            throw new EmptyQueueException( "Caution, empty queue" ) ;

            }

        return queuearr[ frontIndex ] ;

        }


    @Override
    public boolean isEmpty()
        {

        return frontIndex == ( backIndex + 1 ) % capacity ;

        }


    @SuppressWarnings( "unchecked" )
    @Override
    public void clear()
        {
        if ( capacity > DEFAULT_CAPACITY )
            {
            capacity = DEFAULT_CAPACITY ;

            }

        queuearr = (T[]) new Object[ capacity ] ;
        frontIndex = 0 ;
        backIndex = capacity - 1 ;

        }

    }
// end class ArrayQueue