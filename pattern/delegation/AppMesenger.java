package pattern.delegation;

public class AppMesenger<T> implements MessengerInterface<T> {
    private MessengerInterface mesenger;

    public AppMesenger() {
        mesenger = new EmailMessenger();
    }

    static String  description() {
        return "Пример работы шаблона делегирования";
    }

    public MessengerInterface toEmail() {
        mesenger = new EmailMessenger();
        return this;
    }

    public MessengerInterface toSms() {
        mesenger = new SmsMesenger();
        return this;
    }

    @Override
    public  MessengerInterface setSender(T value) {
        mesenger.setSender(value);
        return this;
    }

    @Override
    public MessengerInterface setRecipient(T value) {
        mesenger.setRecipient(value);
        return this;
    }

    @Override
    public MessengerInterface setMessage(T value) {
        mesenger.setMessage(value);
        return this;
    }

    @Override
    public boolean send() {
        return mesenger.send();
    }
}
