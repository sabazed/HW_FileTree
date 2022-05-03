package filetree;

import java.nio.file.Path;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RegularFile extends File {

	public RegularFile(Path path) {
		super(path);
	}

	@Override
	public Iterator<File> iterator() {
		File thisFile = this;
		// Return a new custom iterator
		return new Iterator<>() {
			boolean iterated = false;

			// Regular file is a single object and doesnt have any next elements
			@Override
			public boolean hasNext() {
				return !iterated;
			}

			// If the next() is called an error should be thrown
			@Override
			public File next() {
				if (iterated) throw new NoSuchElementException();
				iterated = true;
				return thisFile;
			}
		};
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public boolean isRegularFile() {
		return true;
	}

}
