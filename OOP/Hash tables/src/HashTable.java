public class HashTable implements Hash {
    private SortedList[] hashArray;
    private int arraySize=0;
    private boolean flag = false;
    public HashTable(int size)
    {
        if (size<1) { return; }
        flag = true;
        arraySize = size;
        hashArray = new SortedList[arraySize];
        for(int j=0; j<arraySize; j++)
            hashArray[j] = new SortedList();
    }
    public void displayTable()
    {
        for(int j=0; j<arraySize; j++)
        {
            System.out.print(j + ". ");
            hashArray[j].displayList();
        }
    }
    public int hashFunc(int key)
    {
        int sum = 0;
        while (key > 0) {
            sum += key % 10;
            key /= 10;
        }
            return sum % arraySize;
    }
    @Override
    public void insert(Link theLink)
    {
        if (!flag) { return; }
        int key = theLink.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(theLink);
    }
    @Override
    public void delete(int key)
    {
        if (arraySize==0) { return; }
        int hashVal = hashFunc(key);
        if (hashArray[hashVal].find(key) == null) { return; }
        hashArray[hashVal].delete(key);
    }
    @Override
    public void find(int key)
    {
        if(arraySize==0) { return; }
        int hashVal = hashFunc(key);
        Link theLink = hashArray[hashVal].find(key);
        if(theLink==null) { System.out.println("Not found"); }
        else { System.out.println("Found"); }
    }
}
