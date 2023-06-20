package iss.controller

import jakarta.validation.Valid
import iss.dto.history.HistoryDto
import iss.dto.securities.SecuritiesDto
import iss.controller.NotFoundException
import iss.service.HistoryAndSecuritiesService
import iss.dto.HistoryAndSecuritiesListParams
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation._


@Controller
@RequestMapping(Array("/historyAndSecurities"))
class HistoryAndSecuritiesController {
  @Autowired private[controller] val historyAndSecuritiesService: HistoryAndSecuritiesService = null

  // Отображение страницы содержащей Историю + Бумаги
  @GetMapping def listPageHistoryAndSecurities(model: Model, historyAndSecuritiesListParams: HistoryAndSecuritiesListParams): String = {
    model.addAttribute("historyAndSecurities", historyAndSecuritiesService.findAllHistoryAndSecuritiesWithParam(historyAndSecuritiesListParams))
    "historyAndSecurities"
  }

  // Создание новой Истории
  @GetMapping(Array("/newHistory")) def newHistory(model: Model): String = {
    model.addAttribute("history", new HistoryDto)
    model.addAttribute("securities", historyAndSecuritiesService.findAllSecurities)
    "history_form"
  }

  // Создание новой Бумаги
  @GetMapping(Array("/newSecurities")) def newSecurities(model: Model): String = {
    model.addAttribute("securities", new SecuritiesDto)
    "securities_form"
  }

  // Редактирование Истории
  @GetMapping(Array("/historyUpdate/{idHistory}")) def editHistory(@PathVariable("idHistory") id: Long, model: Model): String = {
    model.addAttribute("history", historyAndSecuritiesService.findByIdHistory(id).orElseThrow(() => new NotFoundException("History not found")))
    model.addAttribute("securities", historyAndSecuritiesService.findAllSecurities)
    "history_form"
  }

  // Редактирование Бумаги
  @GetMapping(Array("/securitiesUpdate/{idSecurities}")) def editSecurities(@PathVariable("idSecurities") id: String, model: Model): String = {
    model.addAttribute("securities", historyAndSecuritiesService.findByIdSecurities(id).orElseThrow(() => new NotFoundException("Securities not found")))
    "securities_form"
  }

  // Сохранение новой или сохранение изменений в Истории
//  @PostMapping(Array("/historyUpdate")) def updateHistory(@Valid @ModelAttribute("history") history: HistoryDto, result: BindingResult, model: Model): String = {
//    val allList: util.List[SecuritiesDto] = historyAndSecuritiesService.findAllSecurities
//    import scala.collection.JavaConversions._
//    for (sec <- allList) {
//      if (sec.getSecId == history.getSecId) {
//        history.setSecuritiesDto(sec)
//        break //todo: break is not supported
//
//      }
//    }
//    if (history.getSecuritiesDto == null) {
//      model.addAttribute("securities", allList)
//      return "history_form"
//    }
//    if (result.hasErrors) {
//      model.addAttribute("securities", allList)
//      return "history_form"
//    }
//    historyAndSecuritiesService.saveHistory(history)
//    "redirect:/historyAndSecurities"
//  }

  // Сохранение новой или сохранение изменений в Бумаги
  @PostMapping(Array("/securitiesUpdate")) def updateSecurities(@Valid @ModelAttribute("securities") securities: SecuritiesDto, result: BindingResult): String = {
    if (result.hasErrors) return "securities_form"
    historyAndSecuritiesService.saveSecurities(securities)
    "redirect:/historyAndSecurities"
  }

  // Удаление Истории
  @DeleteMapping(Array("/historyDelete/{idHistory}")) def deleteHistory(@PathVariable("idHistory") id: Long): String = {
    historyAndSecuritiesService.deleteByIdHistory(id)
    "redirect:/historyAndSecurities"
  }

  // Удаление Бумаги
  @DeleteMapping(Array("/securitiesDelete/{idSecurities}")) def deleteSecurities(@PathVariable("idSecurities") id: String): String = {
    historyAndSecuritiesService.deleteByIdSecurities(id)
    "redirect:/historyAndSecurities"
  }
}

