package com.ramshad.playlist.controller;

import com.ramshad.playlist.entity.PlaylistEntity;
import com.ramshad.playlist.entity.Song;
import com.ramshad.playlist.form.SongForm;
import com.ramshad.playlist.service.PlaylistService;
import com.ramshad.playlist.view.PlayListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(("/api/v1"))
@CrossOrigin("*")
public class PlaylistController {
    @Autowired
    PlaylistService playlistService;

    @GetMapping("/playlist")
    public List<PlayListView> listPlaylist() {
        return playlistService.loadPlaylist();
    }

    @PostMapping("/createPlaylist")
    public List<PlayListView> addPlaylist(@RequestBody PlaylistEntity pl) {
        System.out.println("coming");
        playlistService.addPlaylist(pl);
        return playlistService.loadPlaylist();
    }

    @DeleteMapping("/playlist/{playListId}")
    private List<PlayListView> deletePlaylist(@PathVariable("playListId") Long playlistId) {
        return playlistService.deletePlaylist(playlistId);
    }


    @GetMapping("/listSongs")
    public List<Song> listSongs() {
        List<Song> songs = playlistService.loadSongs();
        List<PlayListView> rtnList = new ArrayList<>();
        return songs;
    }

    @PostMapping("/addSong")
    public List<Song> addSong(@RequestBody SongForm form,
                              BindingResult bindingResult) {
        return playlistService.addSong(form);
    }

    @DeleteMapping("/delSong/{songId}")
    private List<PlayListView> deleteSong(@PathVariable("songId") Long songId) {
        playlistService.deleteSong(songId);
        return playlistService.loadPlaylist();
    }


}
