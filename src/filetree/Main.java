package filetree;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        File root = FileUtil.toFileRepresentation(Paths.get("C:\\Users\\Saba Dzlieri\\Documents\\Temp"));
        System.out.println(root.getHeight());

        Iterator<File> rootIterator = root.iterator();
        while (rootIterator.hasNext()) System.out.println(rootIterator.next());
        System.out.println(root.getHeight());
    }
}
