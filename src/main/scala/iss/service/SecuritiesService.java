package iss.service;

import iss.demXML.securities.XmlSecurities;
import iss.demXML.securities.XmlListSecurities;
import iss.entity.Securities;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface SecuritiesService {

    XmlListSecurities getDemXmlSecurities() throws JAXBException;
    List<XmlSecurities> findAllXmlSecurities() throws JAXBException;
    List<Securities> saveAllXmlSecurities() throws JAXBException;



}
