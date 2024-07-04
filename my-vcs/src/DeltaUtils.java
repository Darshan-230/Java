import java.util.ArrayList;
import java.util.List;

public class DeltaUtils {

    public static List<String> generateDelta(List<String> oldContent, List<String> newContent) {
        List<String> delta = new ArrayList<>();
        int oldSize = oldContent.size();
        int newSize = newContent.size();
        int i = 0, j = 0;

        while (i < oldSize || j < newSize) {
            if (i < oldSize && j < newSize && oldContent.get(i).equals(newContent.get(j))) {
                i++;
                j++;
            } else {
                if (j < newSize) {
                    delta.add("+ " + newContent.get(j));
                    j++;
                }
                if (i < oldSize) {
                    delta.add("- " + oldContent.get(i));
                    i++;
                }
            }
        }
        return delta;
    }

    public static List<String> applyDelta(List<String> oldContent, List<String> delta) {
        List<String> newContent = new ArrayList<>(oldContent);
        int deltaIndex = 0;

        for (String change : delta) {
            if (change.startsWith("+ ")) {
                newContent.add(deltaIndex, change.substring(2));
                deltaIndex++;
            } else if (change.startsWith("- ")) {
                newContent.remove(deltaIndex);
            } else {
                deltaIndex++;
            }
        }
        return newContent;
    }
}
