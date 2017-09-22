package com.example.demo.dao;

import com.example.demo.model.Glasac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by edin on 16.5.2017..
 * Ovaj interfejs sluzi kao repozitorij za glasaca
 **/

@Repository
public interface GlasacDao extends JpaRepository<Glasac, Integer> {

    /**
     * Brise glasaca iz baze preko jmbg-a
     *
     * @param jmbg jmbg glasaca koji se brise
     * @return vraca listu preostalih glasaca u tabeli
     */
    @Transactional
    List<Glasac> removeByJmbgEquals(String jmbg);

    /**
     * Vraca jednog glasaca preko njegovog jmbg-a
     *
     * @param jmbg trazenog glasaca
     * @return Vraca objekat tipa Glasac
     */
    @Transactional
    Glasac findGlasacByJmbgEquals(String jmbg);
}
