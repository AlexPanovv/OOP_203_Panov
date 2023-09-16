public class Link {
    private int element;
    public Link next;
    public Link(int it)
        { element = it; }
        public int getKey()
        { return element; }
        public void displayLink()
        { System.out.print(element + " "); }
}
