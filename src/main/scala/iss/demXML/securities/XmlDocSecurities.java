package iss.demXML.securities;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "document")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlDocSecurities {
    @XmlElement(name="data")
    XmlDataSecurities xmlDataSecurities;
}
