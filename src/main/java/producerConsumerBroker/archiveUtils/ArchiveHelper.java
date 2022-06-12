package producerConsumerBroker.archiveUtils;

import producerConsumerBroker.Message;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ArchiveHelper {

    List<Message> files;

    public ArchiveHelper(List<Message> files) {
        this.files = files;
    }

    public void archiveFiles() {
        Date dateNow = new Date();
        try (
                ZipOutputStream zot = new ZipOutputStream(new FileOutputStream("/home/v-potapkin/Documents/files/" + dateNow.toString() + ".zip"));) {
            for (Message file : files) {
                FileInputStream fis = new FileInputStream("/home/v-potapkin/Documents/files/" + file.getUuid());
                ZipEntry entry = new ZipEntry(file.getUuid());
                zot.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zot.write(buffer);
                zot.closeEntry();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
