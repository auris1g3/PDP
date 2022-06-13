package producerConsumerBroker;

import lombok.SneakyThrows;
import producerConsumerBroker.archiveUtils.ArchiveHelper;

import java.util.ArrayList;
import java.util.List;


public class HTMLParser {

    private final int countConsumer;

    public HTMLParser(int countConsumer) {
        this.countConsumer = countConsumer;

    }

    public void run() {
        var files = createMessage();

        Broker broker = new Broker();
        new Producer(broker, files);
        createConsumers(broker, countConsumer);

        new ArchiveHelper(files).archiveFiles();
    }

    private List<Message> createMessage() {
        return new MessageHandler().getMessages();
    }

    @SneakyThrows
    private void createConsumers(Broker broker, int countConsumer) {
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
