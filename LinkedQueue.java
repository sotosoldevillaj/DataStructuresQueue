
package queue ;

import utils.Node ;

/**
 * @author Benjamin Lauze
 * 
 * @version 1.0.0 2023-10-03 Initial implementation
 */
public class LinkedQueue<T> implements QueueInterface<T>
    {

    private Node<T> frontNode ;
    private Node<T> backNode ;

    public LinkedQueue()
        {
        frontNode = backNode = null ;

        }


    @Override
    public void enqueue( T newEntry )
        {
        Node<T> toAdd = new Node<>( newEntry ) ;

        if ( backNode == null )
            {
            frontNode = backNode = toAdd ;

            }
        else
            {
            backNode.setNext( toAdd ) ;
            backNode = toAdd ;

            }

        }


    @Override
    public T dequeue()
        {
        if ( isEmpty() )
            {
            throw new EmptyQueueException( "No dequeue from empty queue" ) ;

            }

        T outData = frontNode.getData() ;
        frontNode = frontNode.getNext() ;
        if ( frontNode == null )
            {
            backNode = null ;

            }

        return outData ;

        }


    @Override
    public T getFront()
        {
        if ( isEmpty() )
            {
            throw new EmptyQueueException( "No looking at empty queue" ) ;

            }

        return frontNode.getData() ;

        }


    @Override
    public boolean isEmpty()
        {
        if ( frontNode == null ^ backNode == null )
            {
            throw new IllegalStateException( "Corrupted chain" ) ;

            }

        return frontNode == null ;

        }


    @Override
    public void clear()
        {
        frontNode = backNode = null ;

        }


    /**
     * public static <T> LinkedQueue<T> copy( LinkedQueue<T> original ) { return null
     * ; }
     */

// Testing
    public static void main( String[] args )
        {
        LinkedQueue<String> animals = new LinkedQueue<>() ;

// String s = animals.getFront() ;
// System.out.print( s ) ;

        animals.enqueue( "cat" ) ;
        animals.enqueue( "pig" ) ;
        animals.enqueue( null ) ;
        animals.enqueue( "goat" ) ;

        while ( !animals.isEmpty() )
            {
            System.out.print( animals.dequeue() + " " ) ;

            }

        System.out.println() ;

        animals.enqueue( "cat" ) ;
        animals.enqueue( "pig" ) ;
        animals.enqueue( "wolf" ) ;
        animals.enqueue( "goat" ) ;

        while ( !animals.isEmpty() )
            {
            System.out.print( animals.dequeue() + " " ) ;

            }

        System.out.println() ;

        animals.enqueue( "cat" ) ;
        animals.enqueue( "pig" ) ;
        animals.clear() ;
        animals.enqueue( "wolf" ) ;
        animals.enqueue( "goat" ) ;

        while ( !animals.isEmpty() )
            {
            System.out.print( animals.dequeue() + " " ) ;

            }

        System.out.println() ;

        }

    }
// end class LinkedQueue