public class Subset
{
    public static void main(String[] args)
    {
        RandomizedQueue<String> r = new RandomizedQueue<String>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            r.enqueue(item);
        }
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            StdOut.println(r.dequeue());
        }
    }
}
