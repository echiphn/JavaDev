package org;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import junit.framework.AssertionFailedError;

import org.junit.Test;
import org.xml.sax.SAXException;

public class XMLValidatorTest {

	@Test
	public void testValidator() throws SAXException, IOException {
		SchemaFactory schemaFactory=SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
		Schema schema = schemaFactory.newSchema(new StreamSource(this.getClass().getResourceAsStream("/xsd/configuration.xsd")));
		Validator validator = schema.newValidator();
		try {
			validator.validate(new StreamSource(getClass().getResourceAsStream("/toUnmarshall.xml")));
		} catch (Exception e) {
			fail("sax exception " + e.getMessage());
		}
	}

}
