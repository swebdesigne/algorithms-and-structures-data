package pattern.fundamental.eventchannel;

public interface SubscriberInterface {
    void notify(String data);
    String getName();
}
