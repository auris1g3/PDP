package producerConsumerBroker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MessageHandler implements IMessage {

    @Override
    public List<Message> getMessages() {
        var links = setLinks();
        return getAllMessages(links);
    }

    private String setLinks() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter links please: ");
        String links = in.nextLine();
        in.close();
        return links;
    }

    private List<Message> getAllMessages(String links) {
        var names = links.split(",");
        List<Message> messages = new ArrayList<>();
        for (String name : names) {
            messages.add(new Message(name));
        }
        return messages;
    }
}
