package iss.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping}
import javax.xml.bind.JAXBException
import iss.service.HistoryService

@Controller
@RequestMapping(Array("/historyFromIss")) class HistoryFromIssController {
  @Autowired private[controller] val historyService: HistoryService = null

  // Отображение информации из ISS по истории за определенную дату
  @GetMapping
  @throws[JAXBException]
  def listHistoryFromXml(model: Model): String = {
    model.addAttribute("history", historyService.findAllXmlHistory)
    "historyFromIss"
  }

  // Сохранение информации из ISS в БД по истории за определенную дату
  @GetMapping(Array("/saveHistoryFromIss"))
  @throws[JAXBException]
  def saveListHistoryFromXml: String = {
    historyService.saveAllXmlHistory
    "redirect:/historyFromIss"
  }
}
