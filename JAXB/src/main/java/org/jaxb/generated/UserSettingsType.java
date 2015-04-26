//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.26 at 05:56:49 PM CEST 
//


package org.jaxb.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for user-settingsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="user-settingsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="user-home-directory" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="recent-files" type="{http://book.org/Configuration}recentFilesType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user-settingsType", propOrder = {
    "userHomeDirectory",
    "recentFiles"
})
public class UserSettingsType {

    @XmlElement(name = "user-home-directory", required = true)
    protected String userHomeDirectory;
    @XmlElement(name = "recent-files")
    protected RecentFilesType recentFiles;

    /**
     * Gets the value of the userHomeDirectory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserHomeDirectory() {
        return userHomeDirectory;
    }

    /**
     * Sets the value of the userHomeDirectory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserHomeDirectory(String value) {
        this.userHomeDirectory = value;
    }

    /**
     * Gets the value of the recentFiles property.
     * 
     * @return
     *     possible object is
     *     {@link RecentFilesType }
     *     
     */
    public RecentFilesType getRecentFiles() {
        return recentFiles;
    }

    /**
     * Sets the value of the recentFiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecentFilesType }
     *     
     */
    public void setRecentFiles(RecentFilesType value) {
        this.recentFiles = value;
    }

}