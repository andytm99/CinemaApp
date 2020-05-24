public class TicketObject {
    private String numeClient;
    private int cantitate;
    private MovieObject film;



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
}
