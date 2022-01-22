package pattern.fundamental.eventchannel;

import java.util.*;

public class EventChannel implements EventChannelInterface {
    private Map<String, Set<SubscriberInterface>> topics = new HashMap<>();

    @Override
    public void subscribe(String topic, SubscriberInterface subscriber) {
        if (topics.containsKey(topic)) {
            topics.get(topic).add(subscriber);
        } else {
            Set<SubscriberInterface> subscriberInterfaces = new HashSet<>();
            subscriberInterfaces.add(subscriber);
            topics.putIfAbsent(topic, subscriberInterfaces);
        }
        System.out.println(
                String.format("%s subscribed on [ %s ]",
                    subscriber.getName(),
                    topic
                )
        );
    }

    @Override
    public void publish(String topic, String data) {
        System.out.println(System.lineSeparator());
        System.out.println(topic);
        for (SubscriberInterface s : topics.get(topic)) {
            s.notify(data);
        }
    }
}
