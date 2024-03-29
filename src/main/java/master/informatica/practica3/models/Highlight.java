package master.informatica.practica3.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Highlight
 */
@Entity
public class Highlight {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String url;

    private String title;

    private String imgURL;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destacadosSeries")
    private Serie destacadosSeries;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destacadosMovies")
    private Movie destacadosMovies;

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the destacadosMovies
     */
    public Movie getDestacadosMovies() {
        return destacadosMovies;
    }

    /**
     * @return the destacadosSeries
     */
    public Serie getDestacadosSeries() {
        return destacadosSeries;
    }

    /**
     * @param destacadosMovies the destacadosMovies to set
     */
    public void setDestacadosMovies(Movie destacadosMovies) {
        this.destacadosMovies = destacadosMovies;
    }

    /**
     * @param destacadosSeries the destacadosSeries to set
     */
    public void setDestacadosSeries(Serie destacadosSeries) {
        this.destacadosSeries = destacadosSeries;
    }

    /**
     * @return the imgURL
     */
    public String getImgURL() {
        return imgURL;
    }

    /**
     * @param imgURL the imgURL to set
     */
    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
}