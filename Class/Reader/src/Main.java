public class Main {
    public static void main(String[] args) {
        Reader[] readers = new Reader[3];
        readers[0] = new Reader("Èâàíîâ È. È.", 12345, "Ôèçèêà", "01.01.1990", "123-45-67");
        readers[1] = new Reader("Ïåòðîâ Ï. Ï.", 54321, "Ìàòåìàòèêà", "15.05.1985", "987-65-43");
        readers[2] = new Reader("Ñèäîðîâ Ñ. Ñ.", 13579, "Èíôîðìàòèêà", "20.12.2000", "111-22-33");

        readers[0].takeBook(3);
        readers[1].takeBook("Ïðèêëþ÷åíèÿ", "Ñëîâàðü", "Ýíöèêëîïåäèÿ");
        readers[2].takeBook(new Book("Ïðèêëþ÷åíèÿ", "Àâòîð1"), new Book("Ñëîâàðü", "Àâòîð2"), new Book("Ýíöèêëîïåäèÿ", "Àâòîð3"));

        readers[0].returnBook(2);
        readers[1].returnBook("Ïðèêëþ÷åíèÿ", "Ñëîâàðü");
        readers[2].returnBook(new Book("Ïðèêëþ÷åíèÿ", "Àâòîð1"), new Book("Ñëîâàðü", "Àâòîð2"));
    }
}