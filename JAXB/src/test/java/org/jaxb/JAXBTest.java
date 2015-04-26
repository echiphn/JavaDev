package org.jaxb;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class JAXBTest {
	
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "configuration", propOrder = { "screenName", "webProxy",
			"verbose", "colorName" })
	@XmlRootElement(name = "config")
	static class Configuration {
		private String webProxy;
		private boolean verbose;
		private String colorName;
		private String screenName;

		public String getColorName() {
			return colorName;
		}

		public void setColorName(String colorName) {
			this.colorName = colorName;
		}
	}

	@Test
	public void testMarshall() throws Exception {
		final File f = new File("test.xml");
		assertFalse("File doesn't exist yet ", f.exists());
		Configuration configuration = new Configuration();
		configuration.setColorName("blue");
		JAXBContext jc = JAXBContext.newInstance(Configuration.class);
		Marshaller saver = jc.createMarshaller();

		Writer saveFile = new FileWriter(f);
		saver.marshal(configuration, saveFile);
		saveFile.close();

		assertTrue("File exists now ", f.exists());

		FileUtils.forceDeleteOnExit(f);
	}

	@Test
	public void testUnMarshall() throws Exception {
		final File f = FileUtils.toFile(this.getClass().getResource(
				"/toUnmarshall.xml"));
		JAXBContext jc = JAXBContext.newInstance(Configuration.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();

		Configuration configuration = (Configuration) unmarshaller.unmarshal(f);
		assertNotNull(configuration);
		assertEquals("red", configuration.getColorName());
	}

}
