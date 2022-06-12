package producerConsumerBroker;

import java.util.List;

public class Producer {

    Broker broker;
    List<Message> messageList;

    public Producer(Broker broker, List<Message> messageList) {
        this.broker = broker;
        this.messageList = messageList;
        pushMessage();
    }

    public void pushMessage() {
        for (Message message : messageList) {
            broker.addMessage(message);
        }
    }
}
