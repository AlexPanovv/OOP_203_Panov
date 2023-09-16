public class Main {
    public static void main(String[] args){
        HashTable theHashTable = new HashTable(5);

        theHashTable.insert(new Link(4));
        theHashTable.insert(new Link(4));
        theHashTable.insert(new Link(5));
        theHashTable.insert(new Link(6));
        theHashTable.insert(new Link(8));
        theHashTable.insert(new Link(1));

        theHashTable.delete(587);

        theHashTable.find(5);

        theHashTable.displayTable();
    }
}
