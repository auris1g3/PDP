import lombok.SneakyThrows;
import producerConsumerBroker.Broker;
import producerConsumerBroker.Consumer;
import producerConsumerBroker.MessageHandler;
import producerConsumerBroker.Producer;

import java.util.ArrayList;
import java.util.List;

public class SecondTask {

    @SneakyThrows
    public static void main(String[] args) {

        var file = new MessageHandler().getMessages();

        Broker broker = new Broker();
        new Producer(broker, file);

        create(broker, 3);
    }

    @SneakyThrows
    private static void create(Broker broker, int countConsumer) {
        List<Thread> listThread = new ArrayList<>();
        for (int i = 0; i < countConsumer; i++) {
            Thread thread = new Thread(new Consumer(broker));
            thread.setDaemon(true);
            thread.start();
            listThread.add(thread);
            if (listThread.size() == countConsumer)
                for (int j = 0; j < countConsumer; j++) {
                    listThread.get(i).join();
                }
        }
    }
}
