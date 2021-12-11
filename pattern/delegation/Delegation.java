package pattern.delegation;

public class Delegation {
    public static void main(String[] args) {
        String name = "Делегирование (Delegation)";
        String description = AppMesenger.description();
        AppMesenger item = new AppMesenger();

        System.out.println(name);
        System.out.println(description + "\n");

        item.
                setSender("swebdesigne@gmail.com")
                .setRecipient("beelka2008@gmail.com")
                .setMessage("Hello email messenger!!!").send();

        System.out.println(System.lineSeparator());

        item.toSms()
                .setSender(89_856_980_992L)
                .setRecipient(89_998_823_442L)
                .setMessage("Hello sms messenger").send();
    }
}
