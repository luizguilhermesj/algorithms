import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item>
{

    private int N;
    private Node<Item> first;
    private Node<Item> last;

    private static class Node<Item>
    {
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;
    }

    public Deque()
    {
        first = null;
        last = null;
        N = 0;
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    public void addFirst(Item item)
    {
        if (item == null)
            throw new NullPointerException();
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        first.prev = null;
        if (last == null)
            last = first;
        if (oldfirst != null)
            oldfirst.prev = first;
        N++;
    }

    public void addLast(Item item)
    {
        if (item == null)
            throw new NullPointerException();
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        last.prev = oldlast;
        if (isEmpty())
            first = last;
        else {
            oldlast.next = last;
        }
        N++;
    }

    public Item removeFirst()
    {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");

        Item item = first.item;
        first = first.next;
        if (first != null)
            first.prev = null;
        N--;

        if (isEmpty()) {
            last = null; // to avoid loitering
            first = null;
        }
        return item;
    }

    public Item removeLast()
    {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");
        Item item = last.item; // save item to return
        last = last.prev;
        if (last != null)
            last.next = null;
        N--;

        if (isEmpty()) {
            last = null;
            first = null;
        }
        return item;
    }

    public Iterator<Item> iterator()
    {
        return new ListIterator<Item>(first);
    }

    public static void main(String[] args)
    {
        Deque<Integer> d = new Deque<Integer>();

        d.addFirst(1);

        assert (d.removeLast() == 1);

        d.addLast(4);
        d.addFirst(2);

        assert (d.removeFirst() == 2);

        d.addFirst(3);
        d.addLast(5);
        d.addLast(6);

        Iterator<Integer> it1 = d.iterator();
        Iterator<Integer> it2 = d.iterator();

        assert (it1.next() == 3);
        assert (it1.hasNext() == true);
        assert (it1.next() == 4);
        assert (it1.next() == 5);
        assert (it1.next() == 6);
        assert (it1.hasNext() == false);

        assert (it2.next() == 3);
        assert (it2.hasNext() == true);
        assert (it2.next() == 4);
        assert (it2.next() == 5);
        assert (it2.next() == 6);
        assert (it2.hasNext() == false);

        assert (d.removeLast() == 6);
        assert (d.removeLast() == 5);
        assert (d.removeLast() == 4);
        assert (d.removeLast() == 3);

        d.addFirst(1);
        d.addFirst(2);

        assert (d.removeLast() == 1);
        assert (d.removeLast() == 2);
    }

    private class ListIterator<Item> implements Iterator<Item>
    {
        private Node<Item> current;

        public ListIterator(Node<Item> first)
        {
            current = first;
        }

        public boolean hasNext()
        {
            return current != null;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public Item next()
        {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}