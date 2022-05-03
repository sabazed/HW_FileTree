package filetree;

import java.nio.file.Path;
import java.util.*;

public class Directory extends File {

	private final List<File> files;

	public Directory(Path path, List<File> files) {
		super(path);
		this.files = files;
	}

	@Override
	public Iterator<File> iterator() {
		// Save this object into a variable to use it in the iterator object
		File thisFile = this;
		// If the Directory is empty it should be treated the same way as a RegularFile
		if (files.isEmpty()) return new Iterator<>() {
			boolean iterated = false;

			@Override
			public boolean hasNext() {
				return !iterated;
			}

			@Override
			public File next() {
				if (iterated) throw new NoSuchElementException();
				iterated = true;
				return thisFile;
			}
		};

		// Put all directory files' iterators into a list of iterators
		ArrayList<File> iteratorFiles = new ArrayList<>(files);
		// Add the root Directory to the array
		iteratorFiles.add(0, new Directory(getPath(), new ArrayList<>()));

		// Create a new custom iterator for non-empty Directory
		return new Iterator<>() {
			@Override
			public boolean hasNext() {
				return !iteratorFiles.isEmpty();
			}

			@Override
			public File next() {
				// If the list is empty throw an error
				if (!iteratorFiles.isEmpty()) {
					// Get next File
					File currentFile = iteratorFiles.get(0);
					// Check if the next element is a regular file
					if (currentFile instanceof RegularFile) return iteratorFiles.remove(0);
					// If it is directory add all its children to the iterator array and return the parent
					// Cast currentFile into Directory
					Directory currentDirectory = (Directory) currentFile;
					int index = 0;
					int size = currentDirectory.getFiles().size();
					// Add all files at the start to access child files first
					while (index < size) {
						iteratorFiles.add(index, currentDirectory.getFiles().get(index++));
					}
					// Return the current directory
					return iteratorFiles.remove(index);
				}
				throw new NoSuchElementException();
			}
		};
	}

	@Override
	public int getHeight() {
		// If this is a Regular file or an empty Directory than 0 should be returned
		if (files.isEmpty()) return 0;
		// Return 1 as non-empty Directory has 1 height plus all its children's heights
		return 1 + files.stream().mapToInt(File::getHeight).max().getAsInt();
	}

	@Override
	public boolean isRegularFile() {
		return false;
	}

	public List<File> getFiles() {
		return files;
	}

}
