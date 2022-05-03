package filetree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class FileUtil {

	public static File toFileRepresentation(Path path) throws IOException {
		// If the path is leading to a regular file the root will be RegularFile
		if (Files.isRegularFile(path)) return new RegularFile(path);
		// Otherwise, a Directory should be returned
		return new Directory(path, mapPathsToFiles(Files.list(path)));
	}

	// Create an auxiliary method to initialize Directory objects with other directories in it
	private static List<File> mapPathsToFiles(Stream<Path> files) throws IOException {
		// Map each file into Directory or Regular file
		return files.map(file -> {
			if (Files.isRegularFile(file)) return new RegularFile(file);
			else {
				try {
					// If the file is a Directory then recursively call the same method to initialize its files now
					return new Directory(file, mapPathsToFiles(Files.list(file)));
				} catch (IOException e) {
					try {
						throw e;
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
			return null;
		}).toList(); // Convert stream to a List for the "files" attribute
	}

}
