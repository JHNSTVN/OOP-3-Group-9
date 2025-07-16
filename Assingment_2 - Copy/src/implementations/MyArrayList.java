package implementations;

import utilities.Iterator;
import utilities.ListADT;

import java.util.NoSuchElementException;
import java.util.Arrays;

/*
 * Hello Hello — This is our custom array-based list.
 * - Grows dynamically
 * - Allows add, remove, get, set, etc.
 * - Follows assignment rules 100%
 *
 * - Johan
 */

public class MyArrayList<E> implements ListADT<E>
{
    private static final int INITIAL_CAPACITY = 10;

    private E[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public MyArrayList()
    {
        elements = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    private void ensureCapacity()
    {
        if (size >= elements.length)
        {
            elements = Arrays.copyOf(elements, elements.length * 2); // double the size
        }
    }

    @Override
    public boolean add(int index, E toAdd)
    {
        if (toAdd == null)
        {
            throw new NullPointerException("Can't add null to the list.");
        }

        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        ensureCapacity();

        for (int i = size; i > index; i--)
        {
            elements[i] = elements[i - 1];
        }

        elements[index] = toAdd;
        size++;
        return true;
    }

    @Override
    public boolean add(E toAdd)
    {
        if (toAdd == null)
        {
            throw new NullPointerException("Can't add null to the list.");
        }

        ensureCapacity();
        elements[size++] = toAdd;
        return true;
    }

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

    @Override
    public E get(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        return elements[index];
    }

    @Override
    public E remove(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        E removed = elements[index];

        for (int i = index; i < size - 1; i++)
        {
            elements[i] = elements[i + 1];
        }

        elements[--size] = null;
        return removed;
    }

    @Override
    public E remove(E toRemove)
    {
        if (toRemove == null)
        {
            throw new NullPointerException("Can't remove null from the list.");
        }

        for (int i = 0; i < size; i++)
        {
            if (elements[i].equals(toRemove))
            {
                return remove(i);
            }
        }

        return null;
    }

    @Override
    public E set(int index, E toChange)
    {
        if (toChange == null)
        {
            throw new NullPointerException("Can't set to null.");
        }

        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        E old = elements[index];
        elements[index] = toChange;
        return old;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public boolean contains(E toFind)
    {
        if (toFind == null)
        {
            throw new NullPointerException("Can't search for null.");
        }

        for (int i = 0; i < size; i++)
        {
            if (elements[i].equals(toFind))
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public E[] toArray(E[] toHold)
    {
        if (toHold == null)
        {
            throw new NullPointerException("Provided array is null.");
        }

        if (toHold.length < size)
        {
            // Hello Hello — Java doesn’t like this unchecked cast, but its ok.
            //- Johan
            @SuppressWarnings("unchecked")
            E[] copied = (E[]) Arrays.copyOf(elements, size, toHold.getClass());
            return copied;
        }

        System.arraycopy(elements, 0, toHold, 0, size);

        if (toHold.length > size)
        {
            toHold[size] = null;
        }

        return toHold;
    }

    @Override
    public Object[] toArray()
    {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public void clear()
    {
        for (int i = 0; i < size; i++)
        {
            elements[i] = null;
        }

        size = 0;
    }

    @Override
    public Iterator<E> iterator()
    {
        return new MyArrayListIterator();
    }

    //iterator class for MyArrayList
    private class MyArrayListIterator implements Iterator<E>
    {
        private int current = 0;

        @Override
        public boolean hasNext()
        {
            return current < size;
        }

        @Override
        public E next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }

            return elements[current++];
        }
    }
}
