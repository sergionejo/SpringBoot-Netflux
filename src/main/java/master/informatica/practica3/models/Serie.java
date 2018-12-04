package master.informatica.practica3.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Serie
 */
@Entity
public class Serie {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String url;

    private String imgURL;

    private String title;

    private String description;

    private int yearStart;

    private int yearEnd;

    private int seasons;

    @ManyToMany(cascade = { 
        CascadeType.ALL, 
        CascadeType.MERGE
    })
    @JoinTable(name = "creator_serie",
        joinColumns = @JoinColumn(name = "serie"),
        inverseJoinColumns = @JoinColumn(name = "creator")
    )
    private List<Creator> creators = new ArrayList<>();

    @ManyToMany(cascade = { 
        CascadeType.PERSIST, 
        CascadeType.MERGE
    })
    @JoinTable(name = "cast_serie",
        joinColumns = @JoinColumn(name = "serie"),
        inverseJoinColumns = @JoinColumn(name = "cast")
    )
    private List<Cast> cast = new ArrayList<>();

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
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
     * @return the seasons
     */
    public int getSeasons() {
        return seasons;
    }

    /**
     * @param seasons the seasons to set
     */
    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    /**
     * @return the yearEnd
     */
    public int getYearEnd() {
        return yearEnd;
    }

    /**
     * @param yearEnd the yearEnd to set
     */
    public void setYearEnd(int yearEnd) {
        this.yearEnd = yearEnd;
    }

    /**
     * @return the yearStart
     */
    public int getYearStart() {
        return yearStart;
    }

    /**
     * @param yearStart the yearStart to set
     */
    public void setYearStart(int yearStart) {
        this.yearStart = yearStart;
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
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the creators
     */
    public List<Creator> getCreators() {
        return creators;
    }

    /**
     * @param creators the creators to set
     */
    public void setCreators(List<Creator> creators) {
        this.creators = creators;
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