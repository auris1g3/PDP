import lombok.SneakyThrows;
import producerConsumerBroker.Broker;
import producerConsumerBroker.Consumer;
import producerConsumerBroker.MessageHandler;
import producerConsumerBroker.Producer;
import producerConsumerBroker.archiveUtils.ArchiveHelper;

import java.util.ArrayList;
import java.util.List;

public class SecondTask {

    @SneakyThrows
    public static void main(String[] args) {
        var files = new MessageHandler().getMessages();

        Broker broker = new Broker();
        new Producer(broker, files);
        createConsumers(broker, 3);

        new ArchiveHelper(files).archiveFiles();
    }


    @SneakyThrows
    private static void createConsumers(Broker broker, int countConsumer) {
        List<Thread> listThread = new ArrayList<>();
        for (int i = 0; i < countConsumer; i++) {
            Thread thread = new Thread(new Consumer(broker));
            thread.setDaemon(true);
            thread.start();
            listThread.add(thread);
            if (listThread.size() == countConsumer)
                for (int j = 0; j < countConsumer; j++) {
                    listThread.get(i).join();
                    listThread.get(i).interrupt();
                }
        }
    }
}
