import org.junit.Test;

import static org.junit.Assert.*;

public class TicketObjectTest {

    @Test
    public void getNumeClient() {
        TicketObject t = new TicketObject();
        t.setNumeClient("user");
        String nume= "user";
        assertEquals(nume,t.getNumeClient());
    }

    @Test
    public void setNumeClient() {
        TicketObject t = new TicketObject();
        String nume = "user";
        t.setNumeClient(nume);
        assertEquals(nume,t.getNumeClient());
    }

    @Test
    public void getCantitate() {
        TicketObject t = new TicketObject();
        t.setCantitate(1);
        int cantitate= 1;
        assertEquals(cantitate,t.getCantitate());
    }

    @Test
    public void setCantitate() {
        TicketObject t = new TicketObject();
        int cantitate = 1;
        t.setCantitate(cantitate);
        assertEquals(cantitate,t.getCantitate());
    }

 /*  @Test
    public void getFilm() {
        TicketObject t = new TicketObject();
        MovieObject m = new MovieObject();
        m.setMovieName("ABC");
        MovieObject m2 = m;
        t.setFilm(m2);
        assertEquals(m,t.getFilm());
    }
 */

    @Test
    public void setFilm() {
        TicketObject t = new TicketObject();
        MovieObject m = new MovieObject();
        m.setMovieName("ABC");
        t.setFilm(m);
        assertEquals(m,t.getFilm());
    }

    @Test
    public void getNumeFilm() {
        TicketObject t = new TicketObject();
        t.setNumeFilm("ABC");
        String numeFilm= "ABC";
        assertEquals(numeFilm,t.getNumeFilm());
    }

    @Test
    public void setNumeFilm() {
        TicketObject t = new TicketObject();
        String numeFilm = "ABC";
        t.setNumeClient(numeFilm);
        assertEquals(numeFilm,t.getNumeClient());
    }
}