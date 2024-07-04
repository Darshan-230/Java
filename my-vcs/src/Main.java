import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length < 1) {
                System.out.println("Usage: java Main <command> [args]");
                return;
            }

            String command = args[0];

            switch (command) {
                case "init":
                    Repository.init();
                    break;
                case "commit":
                    if (args.length < 3) {
                        System.out.println("Usage: java Main commit <message> <file>");
                        return;
                    }
                    String message = args[1];
                    String filePath = args[2];
                    Repository.commit(message, filePath);
                    break;
                case "revert":
                    if (args.length < 3) {
                        System.out.println("Usage: java Main revert <commitId> <file>");
                        return;
                    }
                    String commitId = args[1];
                    filePath = args[2];
                    Repository.revert(commitId, filePath); 
                    break;
                default:
                    System.out.println("Unknown command: " + command);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
