package implementations;

/*
 * Hello Hello — This is our node class for MyDLL.
 * Each node stores one element and has links to the next and previous nodes.
 *
 * - Johan
 */

public class MyDLLNode<E>
{
    E element;
    MyDLLNode<E> next;
    MyDLLNode<E> prev;

    public MyDLLNode(E element)
    {
        this.element = element;
        this.next = null;
        this.prev = null;
    }
}
