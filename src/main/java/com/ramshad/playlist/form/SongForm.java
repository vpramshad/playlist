package com.ramshad.playlist.form;

public class SongForm {

    private String name;
    private String singer;
    private Long plId;

    @Override
    public String toString() {
        return "SongForm{" +
                "name='" + name + '\'' +
                ", singer='" + singer + '\'' +
                ", plId=" + plId +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Long getPlId() {
        return plId;
    }

    public void setPlId(Long plId) {
        this.plId = plId;
    }
}