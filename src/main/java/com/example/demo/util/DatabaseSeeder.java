package com.example.demo.util;

import com.example.demo.dao.GlasacDao;
import com.example.demo.dao.KandidatDao;
import com.example.demo.model.Glasac;
import com.example.demo.model.Kandidat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Ova klasa sluzi za unos podataka u tabele odmah nakon bildanja aplikacije
 */
@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private GlasacDao glasacDao;

    @Autowired
    private KandidatDao kandidatDao;

    //@Autowired
    //private StrankaDao strankaDao;

    @Autowired
    public DatabaseSeeder(GlasacDao bookingRepository) {
        this.glasacDao = bookingRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<Glasac> glasaci;

        glasaci = new ArrayList<>();
        Glasac g1 = new Glasac();
        g1.setId(3333);
        g1.setOpcina("Novi Grad");
        g1.setJmbg("0000");

        Glasac g2 = new Glasac();
        g2.setId(1111);
        g2.setOpcina("Novi Grad");
        g2.setJmbg("1111");

        Glasac g3 = new Glasac();
        g3.setId(2222);
        g3.setOpcina("Novi Grad");
        g3.setJmbg("2222");
        glasaci.add(g1);
        glasaci.add(g2);
        glasaci.add(g3);

        /*Stranka s1 = new Stranka();
        s1.setNaziv("AAA");
        Stranka s2 = new Stranka();
        s2.setNaziv("BBB");
        Stranka s3 = new Stranka();
        s3.setNaziv("CCC");

        strankaDao.save(s1);
        strankaDao.save(s2);
        strankaDao.save(s3);*/

        Kandidat k1 = new Kandidat();
        k1.setStranka("SDA");
        k1.setIme("Bakir Izetbegovic");
        k1.setBrojGlasova(50);

        kandidatDao.save(k1);

        Kandidat k2 = new Kandidat();
        k2.setStranka("SBB");
        k2.setIme("Ismir Jusko");
        k2.setBrojGlasova(23);

        kandidatDao.save(k2);

        Kandidat k3 = new Kandidat();
        k3.setStranka("DF");
        k3.setIme("Zeljko Komsic");
        k3.setBrojGlasova(845);

        kandidatDao.save(k3);

        Kandidat k4 = new Kandidat();
        k4.setStranka("SBB");
        k4.setIme("Fahrudin Radoncic");
        k4.setBrojGlasova(2324);

        kandidatDao.save(k4);

        Kandidat k5 = new Kandidat();
        k5.setStranka("SDP");
        k5.setIme("Nermin Niksic");
        k5.setBrojGlasova(23423);

        kandidatDao.save(k5);

        Kandidat k6 = new Kandidat();
        k6.setStranka("HDZ");
        k6.setIme("Dragan Covic");
        k6.setBrojGlasova(123);

        kandidatDao.save(k6);
        glasacDao.save(glasaci);
    }
}

