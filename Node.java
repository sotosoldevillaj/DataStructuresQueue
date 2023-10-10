
package utils ;

/**
 * @author Benjamin Lauze
 * 
 * @version 1.0.0 2023-09-08 Initial implementation
 */
public class Node<T>
    {

    private T data ;
    Node<T> next ;

    public Node( T data, Node<T> nextNode )
        {
        this.data = data ;
        next = nextNode ;

        }


    public Node( T data )
        {
        this( data, null ) ;

        }


    public T getData()
        {
        return data ;

        }


    public Node<T> getNext()
        {
        return next ;

        }


    public void setData( T data )
        {
        this.data = data ;

        }


    public void setNext( Node<T> nextNode )
        {
        next = nextNode ;

        }

    }
// end class Node