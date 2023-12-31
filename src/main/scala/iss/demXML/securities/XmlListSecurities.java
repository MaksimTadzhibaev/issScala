package iss.demXML.securities;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "rows")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlListSecurities {
    @XmlElement(name="row")
    List<XmlSecurities> securities;
}
