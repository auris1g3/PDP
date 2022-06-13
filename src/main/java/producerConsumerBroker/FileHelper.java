package producerConsumerBroker;

import lombok.SneakyThrows;

import java.io.FileOutputStream;

public class FileHelper {

    String name = "v-potapkin";

    @SneakyThrows
    public void saveFile(String contentFile, String fileName) {
        FileOutputStream fos = new FileOutputStream("/home/" + name + "/Documents/files/" + fileName);
        fos.write(contentFile.getBytes());
        fos.flush();
        fos.close();
    }
}
