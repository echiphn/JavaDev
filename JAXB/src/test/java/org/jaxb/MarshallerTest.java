package org.jaxb;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.MarshalException;
import javax.xml.bind.Marshaller;

import org.apache.commons.io.FileUtils;
import org.jaxb.generated.ColorType;
import org.jaxb.generated.ConfigurationType;
import org.jaxb.generated.ObjectFactory;
import org.jaxb.generated.UiSettingsType;
import org.junit.Test;

public class MarshallerTest {

	@Test
	public void testMarshall() throws Exception {
		final File f = new File("test.xml");
		assertFalse("File doesn't exist yet ", f.exists());
		ConfigurationType configuration = createConfigurationType();
		ObjectFactory factory = new ObjectFactory();
		JAXBContext jc = JAXBContext.newInstance(ConfigurationType.class);
		Marshaller saver = jc.createMarshaller();
		try(FileOutputStream fos = new FileOutputStream(f)) {
			saver.marshal(factory.createConfiguration(configuration), fos);
		}
		assertTrue("File exists now ", f.exists());
		FileUtils.forceDeleteOnExit(f);
	}

	/**
	 * directly marshal using java object. Not register via ObjectFactory
	 * @throws Exception
	 */
	@Test(expected=MarshalException.class)
	public void testMarshall_Failed() throws Exception {
		final File f = new File("test.xml");
		assertFalse("File doesn't exist yet ", f.exists());
		ConfigurationType configuration = createConfigurationType();
		JAXBContext jc = JAXBContext.newInstance(ConfigurationType.class);
		Marshaller saver = jc.createMarshaller();
		try(FileOutputStream fos = new FileOutputStream(f)) {
			saver.marshal(configuration, fos);
		}finally{
			FileUtils.forceDeleteOnExit(f);
		}
	}

	private ConfigurationType createConfigurationType() {
		ConfigurationType configuration = new ConfigurationType();
		UiSettingsType uiSettings = new UiSettingsType();
		ColorType backGroundColor = new ColorType();
		backGroundColor.setBlue(10);
		backGroundColor.setGreen(11);
		backGroundColor.setRed(14);
		uiSettings.setBackgroundColor(backGroundColor);
		configuration.setUiSettings(uiSettings);
		return configuration;
	}

}
