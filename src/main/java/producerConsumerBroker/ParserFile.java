package producerConsumerBroker;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ParserFile {
    @SneakyThrows
    public Document getDocument(String url) {
        return Jsoup.parse(url);
    }
}
