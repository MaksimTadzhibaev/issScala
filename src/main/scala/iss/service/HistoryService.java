package iss.service;

import iss.demXML.history.XmlListHistory;
import iss.entity.History;
import iss.demXML.history.XmlHistory;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface HistoryService {
    public XmlListHistory getDemXmlHistory() throws JAXBException;
    List<XmlHistory> findAllXmlHistory() throws JAXBException;
    List<History> saveAllXmlHistory() throws JAXBException;
}