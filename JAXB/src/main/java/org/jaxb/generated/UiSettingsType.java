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
 * <p>Java class for ui-settingsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ui-settingsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="palette-window-position" type="{http://book.org/Configuration}pointType" minOccurs="0"/&gt;
 *         &lt;element name="tools-window-position" type="{http://book.org/Configuration}pointType" minOccurs="0"/&gt;
 *         &lt;element name="background-color" type="{http://book.org/Configuration}colorType" minOccurs="0"/&gt;
 *         &lt;element name="foreground-color" type="{http://book.org/Configuration}colorType" minOccurs="0"/&gt;
 *         &lt;element name="show-tabs" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ui-settingsType", propOrder = {
    "paletteWindowPosition",
    "toolsWindowPosition",
    "backgroundColor",
    "foregroundColor",
    "showTabs"
})
public class UiSettingsType {

    @XmlElement(name = "palette-window-position")
    protected PointType paletteWindowPosition;
    @XmlElement(name = "tools-window-position")
    protected PointType toolsWindowPosition;
    @XmlElement(name = "background-color")
    protected ColorType backgroundColor;
    @XmlElement(name = "foreground-color")
    protected ColorType foregroundColor;
    @XmlElement(name = "show-tabs")
    protected boolean showTabs;

    /**
     * Gets the value of the paletteWindowPosition property.
     * 
     * @return
     *     possible object is
     *     {@link PointType }
     *     
     */
    public PointType getPaletteWindowPosition() {
        return paletteWindowPosition;
    }

    /**
     * Sets the value of the paletteWindowPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link PointType }
     *     
     */
    public void setPaletteWindowPosition(PointType value) {
        this.paletteWindowPosition = value;
    }

    /**
     * Gets the value of the toolsWindowPosition property.
     * 
     * @return
     *     possible object is
     *     {@link PointType }
     *     
     */
    public PointType getToolsWindowPosition() {
        return toolsWindowPosition;
    }

    /**
     * Sets the value of the toolsWindowPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link PointType }
     *     
     */
    public void setToolsWindowPosition(PointType value) {
        this.toolsWindowPosition = value;
    }

    /**
     * Gets the value of the backgroundColor property.
     * 
     * @return
     *     possible object is
     *     {@link ColorType }
     *     
     */
    public ColorType getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Sets the value of the backgroundColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColorType }
     *     
     */
    public void setBackgroundColor(ColorType value) {
        this.backgroundColor = value;
    }

    /**
     * Gets the value of the foregroundColor property.
     * 
     * @return
     *     possible object is
     *     {@link ColorType }
     *     
     */
    public ColorType getForegroundColor() {
        return foregroundColor;
    }

    /**
     * Sets the value of the foregroundColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColorType }
     *     
     */
    public void setForegroundColor(ColorType value) {
        this.foregroundColor = value;
    }

    /**
     * Gets the value of the showTabs property.
     * 
     */
    public boolean isShowTabs() {
        return showTabs;
    }

    /**
     * Sets the value of the showTabs property.
     * 
     */
    public void setShowTabs(boolean value) {
        this.showTabs = value;
    }

}