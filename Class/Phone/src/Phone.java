public class Phone implements java.io.Serializable{
    private String number;
    private String model;
    private double weight;

    public Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public Phone() {
    }

    public Phone(String number, String model) {
        this(number, model, 2.33);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void receiveCall(String name){
        System.out.println("Çâîíèò " + name);
    }

    public void receiveCall(String name, String number){
        System.out.println("Çâîíèò " + name + " ñ íîìåðîì òåëåôîíà " + number);
    }

    public void sendMessages(String... numbers){
        for (String str : numbers){
            System.out.println(str + " ");
        }
    }

}