package master.informatica.practica3.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Movie
 */
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private String imgURL;

    private String title;

    private String description;

    private int year;

    private int duration;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "director")
    private Creator director;

    @ManyToMany(cascade = { 
        CascadeType.PERSIST, 
        CascadeType.MERGE
    })
    @JoinTable(name = "cast_movie",
        joinColumns = @JoinColumn(name = "movie"),
        inverseJoinColumns = @JoinColumn(name = "cast")
    )
    private List<Cast> cast = new ArrayList<>();

    @OneToMany(
        mappedBy = "destacadosMovies", 
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    @JsonIgnore
    private List<Highlight> destacados = new ArrayList<>();

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
     * @return the destacados
     */
    public List<Highlight> getDestacados() {
        return destacados;
    }

    /**
     * @param destacados the destacados to set
     */
    public void setDestacados(List<Highlight> destacados) {
        this.destacados = destacados;
    }
    
    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the director
     */
    public Creator getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(Creator director) {
        this.director = director;
    }

    /**
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the cast
     */
    public List<Cast> getCast() {
        return cast;
    }

    /**
     * @param cast the cast to set
     */
    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
}