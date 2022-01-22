package pattern.fundamental.eventchannel;

public class EventChannelJob {
    public void run() {
        EventChannel evc = new EventChannel();

        Publisher highgardenFroup = new Publisher("highgarden-news", evc);
        Publisher winterfellNews = new Publisher("winterfell-news", evc);
        Publisher winterfellDaily = new Publisher("alternative-news", evc);

        evc.subscribe("highgarden-news", new Subscriber("Cersei Lannister"));
        evc.subscribe("winterfell-news", new Subscriber("Sansa Stark"));

        evc.subscribe("highgarden-news", new Subscriber("Aria Stark"));
        evc.subscribe("winterfell-news", new Subscriber("Aria Stark"));

        evc.subscribe("winterfell-news", new Subscriber("Jon Snow"));

        evc.subscribe("alternative-news", new Subscriber("Jon Snow"));

        highgardenFroup.publish("New highgarder post");
        winterfellNews.publish("New winderfell post");
        winterfellDaily.publish("New alternative winderfell post");
    }

    public static void main(String[] args) {
        EventChannelJob evcj = new EventChannelJob();
        evcj.run();
    }
}
