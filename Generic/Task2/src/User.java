public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void createQuery() {
        Query query = new Query();
        query.printToLog();
    }

    public class Query {
        public void printToLog() {
            System.out.println("Ïîëüçîâàòåëü ñ ëîãèíîì " + login + " è ïàðîëåì " + password + " îòïðàâèë çàïðîñ");
        }
    }
}
