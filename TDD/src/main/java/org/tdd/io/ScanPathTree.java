package org.tdd.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ScanPathTree {
	private static ScanPathTree instance = new ScanPathTree();

	private ScanPathTree() {

	}

	public List<String> getAllFileNames() throws IOException {
		final List<String> fileNames = new ArrayList<String>();
		FileVisitor<Path> myFileVisitor = new SimpleFileVisitor<Path>() {

			@Override
			public FileVisitResult visitFile(Path path,
					BasicFileAttributes attrs) throws IOException {
				System.out.println("Visited file: " + path.toString());
				File visitedFile = path.toFile();
				fileNames.add(visitedFile.getName());
				return FileVisitResult.CONTINUE;
			}

		};
		File visitFolder = FileUtils.toFile(getClass().getResource(
				"/visitFolder"));
		FileSystem fileSystem = FileSystems.getDefault();
		Path start = fileSystem.getPath(visitFolder.getPath());
		Files.walkFileTree(start, myFileVisitor);
		return fileNames;
	}

	public List<String> getAllSubDirNames() throws IOException{
		final List<String> subFolderNames = new ArrayList<String>();
		FileVisitor<Path> myFileVisitor = new SimpleFileVisitor<Path>() {

			@Override
			public FileVisitResult preVisitDirectory(Path dir,
					BasicFileAttributes attrs) throws IOException {
				System.out.println("Visited file: " + dir.toString());
				File visitedFolder = dir.toFile();
				subFolderNames.add(visitedFolder.getName());
				return FileVisitResult.CONTINUE;
			}


		};
		File visitFolder = FileUtils.toFile(getClass().getResource(
				"/visitFolder"));
		FileSystem fileSystem = FileSystems.getDefault();
		Path start = fileSystem.getPath(visitFolder.getPath());
		Files.walkFileTree(start, myFileVisitor);
		return subFolderNames;
	}
	
	public static ScanPathTree getInstance() {
		return instance;
	}
}
