package pattern.fundamental.eventchannel;

public class Subscriber implements SubscriberInterface {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void notify(String data) {
        System.out.println(
                String.format(
                        "%s notified on the data `%s`",
                        name,
                        data
                )
        );
    }

    @Override
    public String getName() {
        return name;
    }
}
