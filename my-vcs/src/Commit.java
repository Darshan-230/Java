import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

public class Commit {

    private String id;
    private String message;
    private Date timestamp;
    private List<String> delta;

    public Commit(String message, List<String> delta) {
        this.id = generateId();
        this.message = message;
        this.timestamp = new Date();
        this.delta = delta;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis());
    }

    public void save() throws IOException {
        Files.createDirectories(Paths.get(".myvcs/commits/" + id));
        try (FileWriter writer = new FileWriter(".myvcs/commits/" + id + "/delta.txt")) {
            for (String change : delta) {
                writer.write(change + "\n");
            }
        }
        try (FileWriter writer = new FileWriter(".myvcs/commits/" + id + "/info.txt")) {
            writer.write("Commit ID: " + id + "\n");
            writer.write("Message: " + message + "\n");
            writer.write("Timestamp: " + timestamp + "\n");
        }
    }

    public String getId() {
        return id;
    }

    public List<String> getDelta() {
        return delta;
    }
}
