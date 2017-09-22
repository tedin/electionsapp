package com.example.demo.controller;

import com.example.demo.dao.GlasacDao;
import com.example.demo.dao.KandidatDao;
import com.example.demo.model.Glasac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by edin on 30.6.2017..
 * Ovaj kontroler koristimo za rendanje view-ova
 */
@Controller
@SessionAttributes("jmbg")
public class HomeController {

    @Autowired
    private KandidatDao kandidatDao;
    @Autowired
    private GlasacDao glasacDao;

    /**
     * Pocetna stranica
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    /**
     * Vraca stranicu sa kandidatima
     *
     * @param model
     * @param model1
     * @return
     */
    @RequestMapping(value = "/izaberi", method = RequestMethod.GET)
    public ModelAndView izaberi(ModelAndView model, Model model1) {
        ModelAndView izaberi = new ModelAndView("/izaberi");
        izaberi.addObject("kandidati", kandidatDao.findAll());
        if (model1.containsAttribute("jmbg"))
            return izaberi;
        else {
            izaberi.setViewName("/error");
            return izaberi;
        }
    }

    /**
     * Metoda koja provjerava da li je JMBG unesen na pocetnoj stranici ispravan
     *
     * @param jmbg
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET/*, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE*/)
    public ModelAndView login(
            @ModelAttribute
                    Glasac jmbg, Model model) {
        Glasac temp = glasacDao.findGlasacByJmbgEquals(jmbg.getJmbg());
        //System.out.println(temp.toString());
        if (temp != null) {
            ModelAndView izaberi = new ModelAndView("redirect:/izaberi");
            model.addAttribute("jmbg", temp.getJmbg());
            return izaberi;

        } else {
            return new ModelAndView("redirect:/error");

        }

    }
}
