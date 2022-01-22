package pattern.fundamental.eventchannel;

public interface EventChannelInterface {
    void publish(String topic, String data);
    void subscribe(String topic, SubscriberInterface subscriber);
}
