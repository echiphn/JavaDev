package org.tdd.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by cle on 13/12/14.
 */
public class DirMonitoring {
	public static void main(String[] args) {
		try {
			DirMonitoring service = new DirMonitoring();
			service.monitoringService();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void monitoringService() throws Exception {
		File testFile = FileUtils.toFile(getClass().getResource("/dirMonitor/test.txt"));
		System.out.println("Watch Event, press q<Enter> to exit");
		FileSystem fileSystem = FileSystems.getDefault();
		WatchService service = fileSystem.newWatchService();
		File dirMonitnor=testFile.getParentFile();
		Path path = FileSystems.getDefault().getPath(dirMonitnor.getPath());
		System.out.println("Watching :" + path.toAbsolutePath());
		path.register(service, StandardWatchEventKinds.ENTRY_CREATE,
				StandardWatchEventKinds.ENTRY_DELETE,
				StandardWatchEventKinds.ENTRY_MODIFY);
		boolean shouldContinue = true;
		while (shouldContinue) {
			WatchKey key = service.poll(250, TimeUnit.MILLISECONDS);

			// Code to stop the program
			while (System.in.available() > 0) {
				int readChar = System.in.read();
				if ((readChar == 'q') || (readChar == 'Q')) {
					shouldContinue = false;
					break;
				}
			}
			if (key == null)
				continue;
			for (WatchEvent<?> event : key.pollEvents()) {
				if (event.kind() == StandardWatchEventKinds.OVERFLOW)
					continue;
				WatchEvent<Path> ev = (WatchEvent<Path>) event;
				Path filename = ev.context();
				System.out.println("Event detected :" + filename.toString()
						+ " " + ev.kind());
			}
			boolean valid = key.reset();
			if (!valid) {
				break;
			}
		}
	}
}
