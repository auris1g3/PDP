package producerConsumerBroker;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Locale;

@Setter
@Getter
public class Message {

    String value,
            uuid;

    public Message(String value) {
        this.value = value;
        this.uuid = randomFileName();
    }

    public static String randomFileName() {
        return ("" + RandomStringUtils.randomAlphanumeric(10) + ".html").toLowerCase(Locale.US);
    }
}
