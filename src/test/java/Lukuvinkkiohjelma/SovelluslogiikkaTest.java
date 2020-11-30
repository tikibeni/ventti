/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lukuvinkkiohjelma;

import Lukuvinkkiohjelma.dao.VinkkiJsonDao;
import Lukuvinkkiohjelma.domain.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hilla
 */
public class SovelluslogiikkaTest {

    Sovelluslogiikka sovelluslogiikka;

    public SovelluslogiikkaTest() {
        sovelluslogiikka = new Sovelluslogiikka(new VinkkiJsonDao("testi"));
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void kirjanLisaysOnnistuu() {
        Kirja kirja = new Kirja("TestO", "TestK", "TestISBN");
        sovelluslogiikka.lisaaVinkki(kirja);
        assertTrue(sovelluslogiikka.listaaKirjat().contains(kirja));
    }

    @Test
    public void kirjanPoistaminenOnnistuu() {
        Kirja kirja = new Kirja("TestO", "TestK", "TestISBN");
        sovelluslogiikka.lisaaVinkki(kirja);
        assertTrue(sovelluslogiikka.listaaKirjat().contains(kirja));
        sovelluslogiikka.poistaVinkki(kirja);
        assertFalse(sovelluslogiikka.listaaKirjat().contains(kirja));
    }

    @Test
    public void bloginLisaysOnnistuu() {
        Blogi blogi = new Blogi("TestO", "TestK", "TestURL");
        sovelluslogiikka.lisaaVinkki(blogi);
        assertTrue(sovelluslogiikka.listaaBlogit().contains(blogi));
    }

    @Test
    public void bloginPoistaminenOnnistuu() {
        Blogi blogi = new Blogi("TestO", "TestK", "TestURL");
        sovelluslogiikka.lisaaVinkki(blogi);
        assertTrue(sovelluslogiikka.listaaBlogit().contains(blogi));
        sovelluslogiikka.poistaVinkki(blogi);
        assertFalse(sovelluslogiikka.listaaBlogit().contains(blogi));
    }

    @Test
    public void podcastinLisaysOnnistuu() {
        Podcast podcast = new Podcast("TestO", "TestURL");
        sovelluslogiikka.lisaaVinkki(podcast);
        assertTrue(sovelluslogiikka.listaaPodcastit().contains(podcast));
    }

    @Test
    public void podcastinPoistaminenOnnistuu() {
        Podcast podcast = new Podcast("TestO", "TestURL");
        sovelluslogiikka.lisaaVinkki(podcast);
        assertTrue(sovelluslogiikka.listaaPodcastit().contains(podcast));
        sovelluslogiikka.poistaVinkki(podcast);
        assertFalse(sovelluslogiikka.listaaBlogit().contains(podcast));
    }
}
