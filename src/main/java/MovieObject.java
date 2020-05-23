import javafx.scene.image.Image;

public class MovieObject {
    private String movieName;
    private String directorName;
    private String descriptionShort;
    private String genre;
    private int minutes;
    //private Image picture;
    public MovieObject()
    {
        this.movieName="";
        this.directorName="";
        this.descriptionShort="";
        this.genre="";
        this.minutes=0;
       // this.picture=new Image();
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getDescriptionShort() {
        return descriptionShort;
    }

    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

   /* public Image getPicture() {
        return picture;
    }

    public void setPicture(Image picture) {
        this.picture = picture;
    }*/
}
