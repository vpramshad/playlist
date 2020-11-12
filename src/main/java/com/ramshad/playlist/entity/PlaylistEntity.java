package com.ramshad.playlist.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class PlaylistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlist_id")
    private Long playListId;
    private String plName;

    public Long getPlayListId() {
        return playListId;
    }

    public void setPlayListId(Long playListId) {
        this.playListId = playListId;
    }

    public String getPlName() {
        return plName;
    }

    public void setPlName(String plName) {
        this.plName = plName;
    }
}
