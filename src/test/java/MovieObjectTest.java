import org.junit.Test;

import static org.junit.Assert.*;

public class MovieObjectTest {

    @org.junit.Test
    public void getMovieName() {
        MovieObject m = new MovieObject();
        m.setMovieName("ABC");
        String numeF = "ABC";
        assertEquals(numeF,m.getMovieName());
    }

    @org.junit.Test
    public void setMovieName() {
        MovieObject m = new MovieObject();
        String numeF = "ABC";
        m.setMovieName(numeF);
        assertEquals(numeF,m.getMovieName());
    }

    @org.junit.Test
    public void getDirectorName() {
        MovieObject m = new MovieObject();
        m.setDirectorName("director");
        String numeD = "director";
        assertEquals(numeD,m.getDirectorName());
    }

    @org.junit.Test
    public void setDirectorName() {
        MovieObject m = new MovieObject();
        String numeD = "director";
        m.setDirectorName(numeD);
        assertEquals(numeD,m.getDirectorName());
    }

    @org.junit.Test
    public void getDescriptionShort() {
        MovieObject m = new MovieObject();
        m.setDescriptionShort("film dragut");
        String descriere = "film dragut";
        assertEquals(descriere,m.getDescriptionShort());
    }

    @org.junit.Test
    public void setDescriptionShort() {
        MovieObject m = new MovieObject();
        String description = "film dragut";
        m.setDescriptionShort(description);
        assertEquals(description,m.getDescriptionShort());
    }

    @org.junit.Test
    public void getGenre() {
        MovieObject m = new MovieObject();
        m.setGenre("actiune");
        String gen = "actiune";
        assertEquals(gen,m.getGenre());
    }

    @org.junit.Test
    public void setGenre() {
        MovieObject m = new MovieObject();
        String gen = "actiune";
        m.setGenre(gen);
        assertEquals(gen,m.getGenre());
    }

    @org.junit.Test
    public void getMinutes() {
        MovieObject m = new MovieObject();
        m.setMinutes(150);
        int minute = 150;
        assertEquals(minute,m.getMinutes());
    }
    @Test
    public void setMinutes() {
        MovieObject m = new MovieObject();
        int minute = 100;
        m.setMinutes(minute);
        assertEquals(minute,m.getMinutes());
    }

    @Test
    public void getCantitateOcupata() {
        MovieObject m = new MovieObject();
        m.setCantitateOcupata(50);
        int cantitateO = 50;
        assertEquals(cantitateO,m.getCantitateOcupata());
    }

    @Test
    public void setCantitateOcupata() {
        MovieObject m = new MovieObject();
        m.setMovieName("ABC");
        int cantitateO = 50;
        m.setCantitateOcupata(cantitateO);
        assertEquals(cantitateO,m.getCantitateOcupata());
    }

    @Test
    public void count() {
        MovieObject m = new MovieObject();
        int cantitateNoua = 50;
        m.setCantitateOcupata(12);
        int total = m.count(cantitateNoua);
        assertEquals(total,m.getCantitateOcupata());
    }

}