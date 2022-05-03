# File Tree
<p>Files are organized in trees (*): Directories can contain regular files and directories.
We now want to model this structure in Java.
For this purpose we define our own classes <code>File</code>,<code>Directory</code> and <code>RegularFile</code>. <code>File</code> is an abstract class from which<code>Directory</code> and <code>RegularFile</code> inherit.
The class <code>Directory</code> is used to represent directories, the class <code>RegularFile</code> represents regular files, i.e. files that are not directories.
A <code>Directory</code> manages a list of<code>files</code> of <code>File</code>s contained in the directory. </p>
<h5 id="readinfiletree">Read in file tree</h5>
<ol>
<li><div class="pe-task-0 d-flex"><jhi-programming-exercise-instructions-task-status _nghost-jro-c178=""><div _ngcontent-jro-c178="" class="guided-tour">
    <!---->
    <!---->
    <fa-icon _ngcontent-jro-c178="" size="lg" class="ng-fa-icon test-icon text-secondary ng-star-inserted"><svg role="img" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="circle-question" class="svg-inline--fa fa-circle-question fa-lg" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path fill="currentColor" d="M256 0C114.6 0 0 114.6 0 256s114.6 256 256 256s256-114.6 256-256S397.4 0 256 0zM256 400c-18 0-32-14-32-32s13.1-32 32-32c17.1 0 32 14 32 32S273.1 400 256 400zM325.1 258L280 286V288c0 13-11 24-24 24S232 301 232 288V272c0-8 4-16 12-21l57-34C308 213 312 206 312 198C312 186 301.1 176 289.1 176h-51.1C225.1 176 216 186 216 198c0 13-11 24-24 24s-24-11-24-24C168 159 199 128 237.1 128h51.1C329 128 360 159 360 198C360 222 347 245 325.1 258z"></path></svg></fa-icon><!---->
    <span _ngcontent-jro-c178="" class="task-name ng-star-inserted">read in directory tree</span><!---->
    
</div>
</jhi-programming-exercise-instructions-task-status></div>Implement the method <code>public static File toFileRepresentation (Path path)</code> in the class <code>FileUtil</code>. 
The method is intended to provide a tree representation of the directory structure which takes the file at the path <code>path</code> as its parameter. Use objects of classes <code>RegularFile</code> and <code>Directory</code> for this purpose. If the file at the path <code>path</code> is a regular file, a representation of this file should be returned. If it is a directory, a representation of the entire file tree from this directory should be returned; the directory with path <code>path</code> should be the root of the tree. If an IOException occurs, you can simply throw it.</li>
</ol>
<h5 id="traversethefiletree">Traverse the file tree</h5>
<p>abstract class <code>File</code> implements the<code>Iteratble &lt;File&gt;</code>interface so that files can be iterated easily.
The necessary <code>iterator</code> method should be implemented in the classes <code>Directory</code> and <code>RegularFile</code>.</p>
<ol start="2">
<li><div class="pe-task-1 d-flex"><jhi-programming-exercise-instructions-task-status _nghost-jro-c178=""><div _ngcontent-jro-c178="" class="guided-tour">
    <!---->
    <!---->
    <fa-icon _ngcontent-jro-c178="" size="lg" class="ng-fa-icon test-icon text-secondary ng-star-inserted"><svg role="img" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="circle-question" class="svg-inline--fa fa-circle-question fa-lg" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path fill="currentColor" d="M256 0C114.6 0 0 114.6 0 256s114.6 256 256 256s256-114.6 256-256S397.4 0 256 0zM256 400c-18 0-32-14-32-32s13.1-32 32-32c17.1 0 32 14 32 32S273.1 400 256 400zM325.1 258L280 286V288c0 13-11 24-24 24S232 301 232 288V272c0-8 4-16 12-21l57-34C308 213 312 206 312 198C312 186 301.1 176 289.1 176h-51.1C225.1 176 216 186 216 198c0 13-11 24-24 24s-24-11-24-24C168 159 199 128 237.1 128h51.1C329 128 360 159 360 198C360 222 347 245 325.1 258z"></path></svg></fa-icon><!---->
    <span _ngcontent-jro-c178="" class="task-name ng-star-inserted">Iterator for regular files</span><!---->
    
</div>
</jhi-programming-exercise-instructions-task-status></div>
<p>Implement the method <code>iterator ()</code> of the interface <code>Iterable &lt;File&gt;</code> inside the class <code>RegularFile</code>.
The iterator should only iterate over the regular file itself.
If <code>next ()</code> is called on the iterator, if all elements have already been iterated, a <code>NoSuchElementException</code> must be thrown.</p></li>
<li><div class="pe-task-2 d-flex"><jhi-programming-exercise-instructions-task-status _nghost-jro-c178=""><div _ngcontent-jro-c178="" class="guided-tour">
    <!---->
    <!---->
    <fa-icon _ngcontent-jro-c178="" size="lg" class="ng-fa-icon test-icon text-secondary ng-star-inserted"><svg role="img" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="circle-question" class="svg-inline--fa fa-circle-question fa-lg" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path fill="currentColor" d="M256 0C114.6 0 0 114.6 0 256s114.6 256 256 256s256-114.6 256-256S397.4 0 256 0zM256 400c-18 0-32-14-32-32s13.1-32 32-32c17.1 0 32 14 32 32S273.1 400 256 400zM325.1 258L280 286V288c0 13-11 24-24 24S232 301 232 288V272c0-8 4-16 12-21l57-34C308 213 312 206 312 198C312 186 301.1 176 289.1 176h-51.1C225.1 176 216 186 216 198c0 13-11 24-24 24s-24-11-24-24C168 159 199 128 237.1 128h51.1C329 128 360 159 360 198C360 222 347 245 325.1 258z"></path></svg></fa-icon><!---->
    <span _ngcontent-jro-c178="" class="task-name ng-star-inserted">Iterator for file tree</span><!---->
    
</div>
</jhi-programming-exercise-instructions-task-status></div>
<p>Implement the method <code>iterator ()</code> of the interface <code>Iterable &lt;File&gt;</code> inside the class <code>Directory</code>.
The method is intended to provide an iterator that iterates over the directory itself, as well as all files directly and indirectly contained (both regular files and directories).
Which means, if necessary, the iterator must also iterate over the elements in the (direct and indirect) subdirectories.
The iteration order is up to you.
If <code>next ()</code> is called on the iterator, if all elements have already been iterated, a <code>NoSuchElementException</code> must be thrown.</p></li>
</ol>
<h5 id="determinetheheightofatree">Determine the height of a tree</h5>
<ol start="4">
<li>[task] <a rel="noopener noreferrer" href="https://artemis.ase.in.tum.de/testHeight">Height of the directory tree</a>
Implement the method <code>public int getHeight ()</code> in <code>Directory</code>.
The method should calculate and return the height of the tree. The object on which it is called is the root.
The object is already the root of a tree; you do not need to access the file system here.
The height of a file tree with a regular file as the root is 0 (already implemented).
The height of a file tree with a directory as its root that has no children (i.e. a directory with no content) is 0.
The height of a file tree with a directory with children is equal to 1 plus the maximum height of the tree that one of the children directory have as the root.</li>
</ol>
<p>(*) You can assume that the directories to be viewed contain no symbolic links.</p>
<h5 id="hints">Hints:</h5>
<ul>
<li>You can see the documentation of <a rel="noopener noreferrer" href="https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/lang/Iterable.html"><code>Iterable</code></a>-Interfaces.</li>
<li>You might need to use method <a rel="noopener noreferrer" href="https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/nio/file/Files.html#list(java.nio.file.Path)"><code>Files.list(...)</code></a> Returns a Stream, the elements of which are the entries in the directory.</li>
<li>The height of the file tree for which your program must work is not greater than 1000.</li>
</ul></div>
</div><!---->
<!---->
</jhi-programming-exercise-instructions><!---->
