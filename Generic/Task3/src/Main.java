public class Main {
    public static void main(String[] args) {
        User user = new User("admin", "123456789");
        user.createQuery();

        User.Query query = new User.Query();
        query.printToLog();
    }
}