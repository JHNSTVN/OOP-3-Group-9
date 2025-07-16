package implementations;

import utilities.Iterator;
import utilities.ListADT;

import java.util.NoSuchElementException;
import java.util.Arrays;

/*
 * Hello Hello 
 * This list lets you move forward and backward using previous and next pointers.
 * 
 * - Johan
 */

public class MyDLL<E> implements ListADT<E>
{
    // Inner Node class to hold data and links
    private class Node
    {
        E data;
        Node prev, next;

        Node(E data)
        {
            this.data = data;
        }
    }

    private Node head, tail;
    private int size;

    // Constructor — start with an empty list
    public MyDLL()
    {
        head = tail = null;
        size = 0;
    }

    // Add an element at a specific index
    @Override
    public boolean add(int index, E toAdd)
    {
        if (toAdd == null)
        {
            throw new NullPointerException("Can't add null to the list.");
        }

        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        Node newNode = new Node(toAdd);

        if (index == 0)
        {
            // Add at head
            newNode.next = head;

            if (head != null)
            {
                head.prev = newNode;
            }

            head = newNode;

            if (size == 0)
            {
                tail = newNode;
            }
        }
        else if (index == size)
        {
            // Add at tail
            newNode.prev = tail;

            if (tail != null)
            {
                tail.next = newNode;
            }

            tail = newNode;

            if (size == 0)
            {
                head = newNode;
            }
        }
        else
        {
            // Insert in the middle
            Node current = getNode(index);
            newNode.prev = current.prev;
            newNode.next = current;

            current.prev.next = newNode;
            current.prev = newNode;
        }

        size++;
        return true;
    }

    // Add to the end of the list
    @Override
    public boolean add(E toAdd)
    {
        return add(size, toAdd);
    }

    // Add all elements from another list
    @Override
    public boolean addAll(ListADT<? extends E> toAdd)
    {
        if (toAdd == null)
        {
            throw new NullPointerException("Can't add from a null list.");
        }

        Iterator<? extends E> it = toAdd.iterator();
        while (it.hasNext())
        {
            add(it.next());
        }

        return true;
    }

    // Get element at index
    @Override
    public E get(int index)
    {
        return getNode(index).data;
    }

    // Remove element at index
    @Override
    public E remove(int index)
    {
        Node node = getNode(index);
        E removed = node.data;

        if (node.prev != null)
        {
            node.prev.next = node.next;
        }
        else
        {
            head = node.next;
        }

        if (node.next != null)
        {
            node.next.prev = node.prev;
        }
        else
        {
            tail = node.prev;
        }

        size--;
        return removed;
    }

    // Remove first matching element by value
    @Override
    public E remove(E toRemove)
    {
        if (toRemove == null)
        {
            throw new NullPointerException("Can't remove null.");
        }

        Node current = head;
        for (int i = 0; i < size; i++)
        {
            if (current.data.equals(toRemove))
            {
                return remove(i);
            }

            current = current.next;
        }

        return null;
    }

    // Replace data at index
    @Override
    public E set(int index, E toChange)
    {
        if (toChange == null)
        {
            throw new NullPointerException("Can't set null.");
        }

        Node node = getNode(index);
        E old = node.data;
        node.data = toChange;
        return old;
    }

    // Check if list is empty
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    // Check if list contains a value
    @Override
    public boolean contains(E toFind)
    {
        if (toFind == null)
        {
            throw new NullPointerException("Can't search for null.");
        }

        Node current = head;
        while (current != null)
        {
            if (current.data.equals(toFind))
            {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Convert list to array using provided array
   @Override
public E[] toArray(E[] toHold)
{
    if (toHold == null)
    {
        throw new NullPointerException("Target array is null.");
    }

    if (toHold.length < size)
    {
        // Hello Hello — Java doesn’t like this generic cast, but it’s ok.
        // We're allowed to use Arrays.copyOf as per the assignment.
        //-Johan
        @SuppressWarnings("unchecked")
        E[] copied = (E[]) Arrays.copyOf(toArray(), size, toHold.getClass());
        return copied;
    }

    Object[] raw = toArray(); 
    System.arraycopy(raw, 0, toHold, 0, size);

    if (toHold.length > size)
    {
        toHold[size] = null; 
    }

    return toHold;
}


    // Convert list to plain Object[] array
    @Override
    public Object[] toArray()
    {
        Object[] array = new Object[size];
        Node current = head;
        int i = 0;

        while (current != null)
        {
            array[i++] = current.data;
            current = current.next;
        }

        return array;
    }

    // Return number of elements
    @Override
    public int size()
    {
        return size;
    }

    // Clear the list
    @Override
    public void clear()
    {
        head = tail = null;
        size = 0;
    }

    // Custom iterator for DLL
    @Override
    public Iterator<E> iterator()
    {
        return new Iterator<E>()
        {
            private Node current = head;

            @Override
            public boolean hasNext()
            {
                return current != null;
            }

            @Override
            public E next()
            {
                if (!hasNext())
                {
                    throw new NoSuchElementException();
                }

                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    // Internal helper to find a node by index
    private Node getNode(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        Node current;

        // Decide whether to start from head or tail
        if (index < size / 2)
        {
            current = head;
            for (int i = 0; i < index; i++)
            {
                current = current.next;
            }
        }
        else
        {
            current = tail;
            for (int i = size - 1; i > index; i--)
            {
                current = current.prev;
            }
        }

        return current;
    }
}
