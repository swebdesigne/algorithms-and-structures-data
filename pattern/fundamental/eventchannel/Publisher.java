package pattern.fundamental.eventchannel;

public class Publisher implements PublisherInterface {
    private String topic;
    private EventChannelInterface eventChannel;

    public Publisher(String topic, EventChannelInterface eventChannel) {
        this.topic = topic;
        this.eventChannel = eventChannel;
    }


    public void publish(String data) {
        eventChannel.publish(topic, data);
    }
}
