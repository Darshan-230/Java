import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Repository {

    private static final String VCS_DIR = ".myvcs";

    public static void init() throws IOException {
        Files.createDirectories(Paths.get(VCS_DIR));
        System.out.println("Initialized empty MyVCS repository in " + Paths.get(VCS_DIR).toAbsolutePath());
    }

    public static void commit(String message, String filePath) throws IOException {
        List<String> oldContent = null;
        List<String> newContent = FileUtils.readFile(filePath);

        if (Files.exists(Paths.get(VCS_DIR + "/latest"))) {
            oldContent = FileUtils.readFile(VCS_DIR + "/latest");
        } else {
            FileUtils.writeFile(VCS_DIR + "/latest", newContent);
            Commit initialCommit = new Commit("Initial commit", List.of());
            initialCommit.save();
        }

        if (oldContent != null) {
            List<String> delta = DeltaUtils.generateDelta(oldContent, newContent);
            Commit commit = new Commit(message, delta);
            commit.save();
            FileUtils.writeFile(VCS_DIR + "/latest", newContent);
        }
    }

    public static void revert(String commitId, String filePath) throws IOException {
        List<String> oldContent = FileUtils.readFile(filePath);
        List<String> delta = FileUtils.readFile(VCS_DIR + "/commits/" + commitId + "/delta.txt");
        List<String> newContent = DeltaUtils.applyDelta(oldContent, delta);
        FileUtils.writeFile(filePath, newContent);
    }
}
