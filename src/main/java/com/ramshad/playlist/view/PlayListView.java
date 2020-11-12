package com.ramshad.playlist.view;

import com.ramshad.playlist.entity.Song;

import java.util.List;

public class PlayListView {

    private String plName;
    private Long id;
    private List<Song> songs;
//    public PlayListView(String plName, Long id) {
        public PlayListView(String plName, Long id, List<Song> songs) {
        this.plName = plName;
        this.id = id;
        this.songs = songs;
    }
    public PlayListView(String plName) {
        this.plName = plName;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public PlayListView() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlName() {
        return plName;
    }

    public void setPlName(String plName) {
        this.plName = plName;
    }

}
