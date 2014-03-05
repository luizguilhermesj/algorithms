import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item>
{
    private Item[] q;
    private int N = 0;

    public RandomizedQueue()
    {
        q = (Item[]) new Object[2];
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    public void enqueue(Item item)
    {
        if (item == null)
            throw new NullPointerException();
        if (N == q.length)
            resize(2 * q.length);

        q[N] = item;
        int random = StdRandom.uniform(N + 1);
        Item temp = q[random];
        q[random] = q[N];
        q[N] = temp;
        N++;
    }

    public Item dequeue()
    {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        if (N > 0 && N == q.length / 4)
            resize(q.length / 2);

        Item item = q[--N];
        q[N] = null;

        return item;
    }

    public Item sample()
    {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        return q[StdRandom.uniform(N)];
    }

    public Iterator<Item> iterator()
    {
        return new ArrayIterator(q);
    }

    public static void main(String[] args)
    {
        RandomizedQueue<Integer> r = new RandomizedQueue<Integer>();

        r.enqueue(1);
        r.dequeue();
        r.enqueue(2);
        r.enqueue(3);
        r.enqueue(4);
        r.enqueue(5);
        r.enqueue(6);
        r.enqueue(7);
        r.dequeue();
        r.dequeue();

        Iterator<Integer> it1 = r.iterator();
        Iterator<Integer> it2 = r.iterator();
        StdOut.print(it1.next());
        assert (it1.hasNext() == true);
        StdOut.print(it1.next());
        StdOut.print(it1.next());
        StdOut.print(it1.next());
        assert (it1.hasNext() == false);

        StdOut.println(" ");
        StdOut.print(it2.next());
        assert (it2.hasNext() == true);
        StdOut.print(it2.next());
        StdOut.print(it2.next());
        StdOut.print(it2.next());
        assert (it2.hasNext() == false);
        StdOut.println(" ");

        for (int i = 0; i < 1000; i++) {
            double rand = StdRandom.uniform((double) 0.0, (double) 1);
            if (rand > 0.5)
                r.enqueue(i);
            else if (rand > 0.2)
                r.dequeue();
            else
                StdOut.println(r.sample());
        }
    }

    private void resize(int max)
    {
        Item[] temp = (Item[]) new Object[max];
        int count = 0;
        for (int i = 0; i < q.length; i++) {
            if (q[i] != null) {
                temp[count] = q[i];
                count++;
            }
        }
        q = temp;
    }

    private class ArrayIterator implements Iterator<Item>
    {
        private int i = 0;
        private Item[] q;

        public ArrayIterator(Item[] itemArray)
        {
            this.q = (Item[]) new Object[N];
            for (int j = 0; j < N; j++) {
                this.q[j] = itemArray[j];
            }
            StdRandom.shuffle(this.q);
        }

        public boolean hasNext()
        {
            return i < N;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public Item next()
        {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = this.q[i];
            i++;
            return item;
        }
    }
}