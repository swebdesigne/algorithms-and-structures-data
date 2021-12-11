package pattern.fundamental.delegation;

interface MessengerInterface<T> {
    MessengerInterface setSender(T value);

    MessengerInterface setRecipient(T value);

    MessengerInterface setMessage(T value);

    boolean send();
}
