package org.tdd.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class ZipFileListContentTest {

	@Test
	public void testListContentOfZipFile() throws Exception {
		List<String> expectedFileNames=Arrays.asList("test.txt");
		List<String> actualFileNames=new ArrayList<String>();
		File file=FileUtils.toFile(this.getClass().getResource("/io/test.zip"));
		ZipFile zipfile = new ZipFile(file);
		Enumeration<? extends ZipEntry> entries = zipfile.entries();
		while(entries.hasMoreElements()){
			ZipEntry zipEntry = entries.nextElement();
			actualFileNames.add(zipEntry.getName());
		}
		
		assertTrue(ListUtils.isEqualList(expectedFileNames, expectedFileNames));
		
		zipfile.close();
	}

}
