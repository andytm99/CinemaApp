public class TicketObject {
    private String numeClient;
    private int cantitate;
    private MovieObject film;
    private String numeFilm;


    public String getNumeClient() {
        return numeClient;
    }

    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public MovieObject getFilm() {
        return film;
    }

    public void setFilm(MovieObject film) {
        this.film = film;
    }

    public String getNumeFilm() {
        return numeFilm;
    }

    public void setNumeFilm(String numeFilm) {
        this.numeFilm = numeFilm;
    }
}
