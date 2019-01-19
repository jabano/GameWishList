package com.example.jeneska.gamewishlist;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "gameTable")
public class Game {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "platform")
    private String platform;

    @ColumnInfo(name = "genre")
    private String genre;

    @ColumnInfo(name = "interest")
    private String interest;

    @ColumnInfo(name = "costRange")
    private String costRange;

    @ColumnInfo(name = "releaseDate")
    private String releaseDate;

    //Constructor
    public Game(String title, String platform, String genre, String costRange, String interest, String releaseDate) {
        this.title = title;
        this.platform = platform;
        this.genre = genre;
        this.costRange = costRange;
        this.interest = interest;
        this.releaseDate = releaseDate;
    }
    //Getters/Setters

    //ID
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //Title
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    //Platform
    public String getPlatform() {
        return platform;
    }
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    //Genre
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    //Interest
    public String getInterest() {
        return interest;
    }
    public void setInterest(String interest) {
        this.interest = interest;
    }

    //Cost Range
    public String getCostRange() {
        return costRange;
    }
    public void setCostRange(String costRange) {
        this.costRange = costRange;
    }

    //Release Date
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}

