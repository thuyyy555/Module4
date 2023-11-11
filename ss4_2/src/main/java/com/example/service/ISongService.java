package com.example.service;

import com.example.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);
}
