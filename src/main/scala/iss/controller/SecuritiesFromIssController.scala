package iss.controller

import iss.service.SecuritiesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.xml.bind.JAXBException

@Controller
@RequestMapping(Array("/securitiesFromIss")) class SecuritiesFromIssController {
  @Autowired private[controller] val securitiesService: SecuritiesService = null

  // Отображение информации из ISS по бумаге за определенную дату
  @GetMapping
  @throws[JAXBException]
  def listSecuritiesFromXml(model: Model): String = {
    model.addAttribute("securities", securitiesService.findAllXmlSecurities)
    "securitiesFromIss"
  }

  // Сохранение информации из ISS в БД по бумаге за определенную дату
  @GetMapping(Array("/saveSecuritiesFromIss"))
  @throws[JAXBException]
  def saveListSecuritiesFromXml: String = {
    securitiesService.saveAllXmlSecurities
    "redirect:/securitiesFromIss"
  }
}