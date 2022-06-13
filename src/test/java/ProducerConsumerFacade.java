import lombok.SneakyThrows;
import producerConsumerBroker.HTMLParser;

public class ProducerConsumerFacade {

    @SneakyThrows
    public static void main(String[] args) {

        new HTMLParser(3).run();
    }
}
