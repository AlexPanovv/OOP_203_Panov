public class Reader {
    private String fullName;
    private int readerTicketNumber;
    private String faculty;
    private String dateOfBirth;
    private String phoneNumber;

    public Reader(String fullName, int readerTicketNumber, String faculty, String dateOfBirth, String phoneNumber) {
        this.fullName = fullName;
        this.readerTicketNumber = readerTicketNumber;
        this.faculty = faculty;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public void takeBook(int numberOfBooks) {
        System.out.println(fullName + " âçÿë " + numberOfBooks + " êíèãè");
    }

    public void takeBook(String... bookNames) {
        System.out.print(fullName + " âçÿë êíèãè: ");
        for (String book : bookNames) {
            System.out.print(book + ", ");
        }
        System.out.println();
    }

    public void takeBook(Book... books) {
        System.out.print(fullName + " âçÿë êíèãè: ");
        for (Book book : books) {
            System.out.print(book.getName() + " îò " + book.getAuthor() + ", ");
        }
        System.out.println();
    }

    public void returnBook(int numberOfBooks) {
        System.out.println(fullName + " âåðíóë " + numberOfBooks + " êíèãè");
    }

    public void returnBook(String... bookNames) {
        System.out.print(fullName + " âåðíóë êíèãè: ");
        for (String book : bookNames) {
            System.out.print(book + ", ");
        }
        System.out.println();
    }

    public void returnBook(Book... books) {
        System.out.print(fullName + " âåðíóë êíèãè: ");
        for (Book book : books) {
            System.out.print(book.getName() + " îò " + book.getAuthor() + ", ");
        }
        System.out.println();
    }
}

