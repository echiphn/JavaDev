package org.jaxb;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class ConfigurationTest {

	@Test
	public void testMarshall() throws Exception {
		final File f = new File("test.xml");
		assertFalse("File doesn't exist yet ", f.exists());
		Configuration configuration = new Configuration();
		configuration.setColorName("blue");
		JAXBContext jc = JAXBContext.newInstance(Configuration.class);
		Marshaller saver = jc.createMarshaller();

		// We save their preferences
		// Configuration c = ... - set above
		Writer saveFile = new FileWriter(f);
		saver.marshal(configuration, saveFile);
		saveFile.close();

		// Confirm that the XML file got written
		assertTrue("File exists now ", f.exists());

		FileUtils.forceDeleteOnExit(f);
	}
	
	@Test
	public void testUnMarshall() throws Exception {
		final File f = FileUtils.toFile(this.getClass().getResource("/toUnmarshall.xml"));
		JAXBContext jc = JAXBContext.newInstance(Configuration.class);
		Unmarshaller unmarshaller=jc.createUnmarshaller();

		Configuration configuration=(Configuration) unmarshaller.unmarshal(f);
		assertNotNull(configuration);
		assertEquals("red",configuration.getColorName());
	}

}
