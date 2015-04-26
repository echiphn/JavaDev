package org.jaxp;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParserTest {

	@Test
	public void testRead_Color() throws ParserConfigurationException,
			SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		DefaultHandler dh = getHandler();
		parser.parse(this.getClass().getResourceAsStream("/toUnmarshall.xml"),
				dh);
		assertEquals("red", ((ColorNameHandler) dh).getColorName());
	}

	class ColorNameHandler extends DefaultHandler {
		private String colorName;
		private Stack<String> events;
		private static final String READ_COLOR = "readColor";

		public ColorNameHandler() {
			super();
			events = new Stack<String>();
		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			super.startElement(uri, localName, qName, attributes);
			if ("colorName".equals(qName)) {
				System.out.println("start reading color name ...");
				events.push(READ_COLOR);
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			super.endElement(uri, localName, qName);
			if ("colorName".equals(qName)) {
				System.out.println("end reading color name ...");
				events.pop();
			}
		}

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			super.characters(ch, start, length);
			if (events.contains(READ_COLOR)) {
				StringBuilder builder = new StringBuilder();
				char[] dataContent = Arrays.copyOfRange(ch, start, start
						+ length);
				builder.append(dataContent);
				colorName = builder.toString();
			}
		}

		String getColorName() {
			return colorName;
		}

	}

	private DefaultHandler getHandler() {

		return new ColorNameHandler();
	}

}
