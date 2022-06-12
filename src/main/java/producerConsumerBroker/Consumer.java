package producerConsumerBroker;

public class Consumer implements Runnable {

    final Broker broker;

    public Consumer(Broker broker) {
        this.broker = broker;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (broker.isHaveMessage()) {
                Message message = broker.getMessage();
                var fileName = message.getUuid();
                var value = message.getValue();
                var document = new ParserFile().getDocument(fileName).toString();
                System.out.println(Thread.currentThread().getName() + ":  " + value + " / " + fileName);
                new FileHelper().saveFile(document, fileName);
            } else
                break;
        }
    }
}