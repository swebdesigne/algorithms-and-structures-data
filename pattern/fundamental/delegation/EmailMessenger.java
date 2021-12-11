package pattern.fundamental.delegation;

public class EmailMessenger<T> extends AbstractMessenger<T> {
    public boolean send() {
        System.out.println("Send by " + super.sender);
        System.out.println("Send by " + super.recipient);
        System.out.println("Send by " + super.message);
        return super.send();
    }
}
