package com.example.demo.controller;

import com.example.demo.dao.KandidatDao;
import com.example.demo.model.Kandidat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by edin on 28.6.2017..
 * Kontroler za kandidate
 */
@RestController
public class KandidatController {

    @Autowired
    private KandidatDao kandidatDao;

    /**
     * Metoda koja vraca sve kandidate
     *
     * @return
     */
    @RequestMapping(value = "/kandidati", method = RequestMethod.GET)
    public List<Kandidat> vratiSveKandidate() {
        return kandidatDao.findAll();
    }

    /**
     * Metoda koja vraca kandidate za nacelnika
     *
     * @return
     */
    @RequestMapping(value = "/kandidati/nacelnici", method = RequestMethod.GET)
    public List<Kandidat> vratiSveNacelnike() {
        System.out.println("Dosao request za nacelnike");
        return kandidatDao.getAllByPozicijaEquals("Nacelnik");
    }

    /**
     * Metoda koja obradjuje glasove
     *
     * @param id kandidata za kojeg se glasa
     * @return
     */
    @RequestMapping(value = "/glasaj/{id}", method = RequestMethod.GET)
    public ModelAndView glasajZa(
            @PathVariable(name = "id")
                    int id) {
        kandidatDao.povecajBrojGlasova(id);
        return new ModelAndView("/index");
    }

    /**
     * Metoda koja vraca rezultate svih kandidata
     *
     * @return
     */
    @RequestMapping(value = "/rezultati", method = RequestMethod.GET)
    public ModelAndView rezultatiStranka() {
        ModelAndView rezulati = new ModelAndView("rezultati");
        rezulati.addObject("rezultati", kandidatDao.getAllStrankaVotes());
        return rezulati;
    }

    /**
     * Metoda koja vraca rezultate po opcinama i strankama
     *
     * @param opcina
     * @param stranka
     * @return
     */
    @RequestMapping(value = "/rezultati/{opcina}/{stranka}", method = RequestMethod.GET)
    public int rezultatiOpcina(
            @PathVariable(name = "opcina")
                    String opcina,
            @PathVariable(name = "stranka")
                    String stranka) {
        return kandidatDao.getAllStrankaVotesWhereOpcinaEquals(opcina, stranka);
    }
}
