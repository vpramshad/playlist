package com.ramshad.playlist.form;

public class PlaylistForm {

    private String plName;

    public String getPlName() {
        return plName;
    }

    public void setPlName(String plName) {
        this.plName = plName;
    }

    @Override
    public String toString() {
        return "PlaylistForm{" +
                "plName='" + plName + '\'' +
                '}';
    }

}
