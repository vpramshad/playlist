package com.ramshad.playlist.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songIds;
    private String songName;
    private String singer;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "playlist_id")
    private PlaylistEntity playlist;

    public Song() {
    }

    public Song(String name, String singer) {
        this.songName = name;
        this.singer = singer;
    }

    public Song(String name, String singer, PlaylistEntity playlist ) {
        this.songName = name;
        this.singer = singer;
        this.playlist = playlist;
    }


    public Song(Long songIds, String songName, String singer, PlaylistEntity playlist) {
        this.songIds = songIds;
        this.songName = songName;
        this.singer = singer;
        this.playlist = playlist;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songIds=" + songIds +
                ", songName='" + songName + '\'' +
                ", singer='" + singer + '\'' +
                ", playlist=" + playlist +
                '}';
    }

    public PlaylistEntity getPlaylist() {
        return playlist;
    }

    public void setPlaylist(PlaylistEntity playlist) {
        this.playlist = playlist;
    }

    public Long getSongIds() {
        return songIds;
    }

    public void setSongIds(Long songIds) {
        this.songIds = songIds;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
