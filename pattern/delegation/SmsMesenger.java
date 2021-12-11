package pattern.delegation;

public class SmsMesenger extends AbstractMessenger {
    public boolean send() {
        System.out.println("Send by " + super.sender);
        System.out.println("Send by " + super.recipient);
        System.out.println("Send by " + super.message);
        return super.send();
    }
}
