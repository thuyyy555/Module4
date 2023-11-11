package com.example.model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private int id;
    private String nameSong;
    private String composer;
    private String musicGenre;
    private MultipartFile filePath;

    public SongForm() {
    }

    public SongForm(int id, String nameSong, String composer, String musicGenre, MultipartFile filePath) {
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

    public MultipartFile getFilePath() {
        return filePath;
    }

    public void setFilePath(MultipartFile filePath) {
        this.filePath = filePath;
    }
}
