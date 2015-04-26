package org.jaxb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.stream.StreamSource;

import org.jaxb.generated.ColorType;
import org.jaxb.generated.ConfigurationType;
import org.junit.Test;

public class UnmarshallerTest {

	@Test
	public void testUnmarshall() throws JAXBException {
		ConfigurationType configType = null;
		JAXBContext ctx = JAXBContext.newInstance(ConfigurationType.class);
		Unmarshaller unmarshaller = ctx.createUnmarshaller();
		JAXBElement<ConfigurationType> result = unmarshaller.unmarshal(
				new StreamSource(getClass().getResourceAsStream(
						"/toUnmarshall.xml")), ConfigurationType.class);
		configType = result.getValue();
		assertNotNull(configType);
		assertNotNull(configType.getUiSettings());
		ColorType backGroundColor = configType.getUiSettings()
				.getBackgroundColor();
		assertNotNull(backGroundColor);
		assertEquals(2, backGroundColor.getAlpha());
		assertEquals(11, backGroundColor.getBlue());
	}

	@Test
	public void testUnmarshall_NoTypeDeclaration() throws JAXBException,
			XMLStreamException {
		ConfigurationType configType = null;
		JAXBContext ctx = JAXBContext.newInstance("org.jaxb.generated");
		Unmarshaller unmarshaller = ctx.createUnmarshaller();
		@SuppressWarnings("unchecked")
		JAXBElement<ConfigurationType> result = (JAXBElement<ConfigurationType>) unmarshaller
				.unmarshal(getClass().getResourceAsStream("/toUnmarshall.xml"));
		configType = result.getValue();
		assertNotNull(configType);
		assertNotNull(configType.getUiSettings());
		ColorType backGroundColor = configType.getUiSettings()
				.getBackgroundColor();
		assertNotNull(backGroundColor);
		assertEquals(2, backGroundColor.getAlpha());
		assertEquals(11, backGroundColor.getBlue());
	}

	
}
