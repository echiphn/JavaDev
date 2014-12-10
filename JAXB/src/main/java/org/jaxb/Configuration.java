package org.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "configuration", propOrder = { "screenName", "webProxy",
		"verbose", "colorName" })
@XmlRootElement(name = "config")
public class Configuration {
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
