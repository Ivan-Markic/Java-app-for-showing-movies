/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author ivanm
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie {
    
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    private int id;
    private String title;
    @XmlElement(name = "originaltitle")
    private String originalTitle;
    private String description;
    @XmlElement(name = "picturepath")
    private String picturePath;
    private int length;
    private String genre;
    private String link;
    
    @XmlElementWrapper
    @XmlElement(name = "actor")
    private List<Person> actors;
    
    @XmlJavaTypeAdapter(PublishedDateAdapter.class)
    @XmlElement(name = "publisheddate")
    private LocalDateTime publishedDate;
    
    @XmlElementWrapper
    @XmlElement(name = "director")
    private List<Person> directors;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    

    public Movie() {
    }

    public Movie(int id, String title, String originalTitle, String description, int length, String genre, String link, LocalDateTime publishedDate, String picturePath) {
        this(title, originalTitle, description, picturePath, length, genre, link, publishedDate);
        this.id = id;
    }

    public Movie(String title, String originalTitle, String description, String picturePath, int length, String genre, String link, LocalDateTime publishedDate) {
        this.title = title;
        this.originalTitle = originalTitle;
        this.description = description;
        this.picturePath = picturePath;
        this.length = length;
        this.genre = genre;
        this.link = link;
        this.publishedDate = publishedDate;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Person> getActors() {
        return actors;
    }

    public void setActors(List<Person> actors) {
        this.actors = actors;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public List<Person> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Person> directors) {
        this.directors = directors;
    }
    @Override
    public String toString() {
        return id + " - " + title + " - " + publishedDate;
    }

    public String formatForFileLine() {
        return toString();
    }
    
    
}
