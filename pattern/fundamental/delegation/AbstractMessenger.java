package pattern.fundamental.delegation;

abstract class AbstractMessenger<T> implements  MessengerInterface<T> {
    protected T sender;
    protected T message;
    protected T recipient;

    @Override
    public MessengerInterface setSender(T value) {
        sender = value;
        return this;
    }

    @Override
    public MessengerInterface setRecipient(T value) {
        recipient = value;
        return this;
    }

    @Override
    public MessengerInterface setMessage(T value) {
        message = value;
        return this;
    }

    @Override
    public boolean send() {
        return true;
    }
}
