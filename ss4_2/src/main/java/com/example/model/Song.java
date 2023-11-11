package com.example.model;

public class Song {
    private int id;
    private String nameSong;
    private String composer;
    private String musicGenre;
    private String filePath;

    public Song() {
    }

    public Song(int id, String nameSong, String composer, String musicGenre, String filePath) {
        this.id = id;
        this.nameSong = nameSong;
        this.composer = composer;
        this.musicGenre = musicGenre;
        this.filePath = filePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
