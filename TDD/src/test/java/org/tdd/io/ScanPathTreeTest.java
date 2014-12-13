package org.tdd.io;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

public class ScanPathTreeTest {
	private ScanPathTree scanner=ScanPathTree.getInstance();
	@Test
	public void testGetFileNames() throws IOException {
		List<String> expectedNames=Arrays.asList("testfile1.txt","testfile2.txt","testfile3.txt","testfile4.txt");
		assertTrue(CollectionUtils.isEqualCollection(expectedNames, scanner.getAllFileNames()));
	}
	@Test
	public void testGetSubDirNames() throws IOException {
		List<String> expectedNames=Arrays.asList("visitFolder","subFolder","subFolder2");
		assertTrue(CollectionUtils.isEqualCollection(expectedNames, scanner.getAllSubDirNames()));
	}

}
