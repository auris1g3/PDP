package producerConsumerBroker;

import lombok.NonNull;
import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;

public class Broker {

    private final ArrayBlockingQueue<Message> queue;

    public Broker() {
        this.queue = new ArrayBlockingQueue<>(100);
    }

    @SneakyThrows
    public void addMessage(@NonNull Message message) {
        this.queue.put(message);
    }

    @SneakyThrows
    public Message getMessage() {
        return this.queue.take();
    }

    public boolean isHaveMessage() {
        return this.queue.size() > 0;
    }
}
