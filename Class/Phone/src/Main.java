public class Main {
    public static void main(String[] args) {
        Phone phone1 = new Phone("89631654205", "RealmeXT", 0.183);
        Phone phone2 = new Phone("89876543210", "Samsung", 0.202);
        Phone phone3 = new Phone("89279685567", "Realme10", 0.195);
        System.out.println(phone1.getModel());
        System.out.println(phone2.getNumber());
        System.out.println(phone3.getWeight());
        phone1.receiveCall("Sasha");

        Phone phone4 = new Phone("89631654205","realmeXT");
        System.out.println(phone4.getWeight());
        System.out.println(phone4.getModel());
        System.out.println(phone4.getNumber());
        phone3.receiveCall("Alexander","89631654205");
        phone4.sendMessages("89631654205","89631654205","89631654205");
    }
}