package com.example.demo.dao;

import com.example.demo.model.Kandidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by edin on 16.5.2017..
 * Ovaj interfejs sluzi kao repozitorij za upravljanje kandidatima u bazi
 **/

@Repository
public interface KandidatDao extends JpaRepository<Kandidat, Integer> {

    /**
     * Vraca sve kandidate prema poziciji
     *
     * @param pozicija naziv pozicije
     * @return Lista kandidata po poziciji
     */
    @Transactional
    List<Kandidat> getAllByPozicijaEquals(String pozicija);

    /**
     * Povecava broj glasova odredjenom kandidatu
     *
     * @param id prima id kandidata kojem se glasovi povecavaju
     */
    @Modifying
    @Transactional
    @Query("UPDATE Kandidat k SET k.brojGlasova = k.brojGlasova + 1 WHERE k.id = :id")
    void povecajBrojGlasova(
            @Param("id")
                    int id);

    /**
     * Vraca sve kandidate
     *
     * @return
     */
    @Transactional
    @Query(" select k from Kandidat k")
    List<Kandidat> getAllStrankaVotes();

    /**
     * Vraca broj glasova kandidata po opcinama i strankama
     *
     * @param opcina
     * @param stranka
     * @return
     */
    @Transactional
    @Query("SELECT SUM(k.brojGlasova) FROM Kandidat k WHERE k.opcina = :opcina and k.stranka = :stranka")
    int getAllStrankaVotesWhereOpcinaEquals(
            @Param("opcina")
                    String opcina,
            @Param("stranka")
                    String stranka);

}
