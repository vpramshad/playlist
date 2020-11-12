package com.ramshad.playlist.service;

import com.ramshad.playlist.entity.Song;
import com.ramshad.playlist.entity.PlaylistEntity;
import com.ramshad.playlist.form.SongForm;
import com.ramshad.playlist.repository.PlaylistRepository;
import com.ramshad.playlist.repository.SongRepository;
import com.ramshad.playlist.view.PlayListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    PlaylistRepository plRepository;

    @Autowired
    SongRepository songRepository;

    @Override
    public List<PlayListView> loadPlaylist() {
        List<PlaylistEntity> playlists = new ArrayList<>();
        plRepository.findAll().forEach(e -> playlists.add(e));
        List<PlayListView> views = new ArrayList<>();
        playlists.forEach(pl -> {
            PlayListView view = checkAndLoadSongs(pl);
            views.add(view);
        });
        return views;
    }

    private PlayListView checkAndLoadSongs(PlaylistEntity playList) {
        List<Song> loadedSongList = new ArrayList<>();
        songRepository.findAll().forEach(loadedSongList::add);
        List<Song> resultList = loadedSongList.stream().filter(
                e -> e.getPlaylist().getPlayListId() == playList.getPlayListId()
        ).collect(Collectors.toList());
        PlayListView view = new PlayListView(playList.getPlName(),playList.getPlayListId(),resultList);
        return  view;
    }

    @Override
    public PlayListView addPlaylist(PlaylistEntity pl) {
        //PlaylistEntity entity = new PlaylistEntity();
        //entity.setPlName(form.getPlName());
        pl = plRepository.save(pl);
        PlayListView view = new PlayListView();
        view.setPlName(pl.getPlName());
        return view;
    }

    @Override
    public List<PlayListView> deletePlaylist(Long playlistId) {
        plRepository.deleteById(playlistId);
        return loadPlaylist();
    }

    @Override
    public List<Song> deleteSong(Long songId) {
        songRepository.deleteById(songId);
        return loadSongs();
    }

    @Override
    public List<Song> addSong(SongForm form) {
        PlaylistEntity pl = plRepository.findById(form.getPlId()).get();
        Song song = new Song(form.getName(),form.getSinger(),pl);
        songRepository.save(song);
        return loadSongs();
    }

    public List<Song> loadSongs() {
        List<Song> songs = new ArrayList<>();
        songRepository.findAll().forEach(songs::add);
        return  songs;
    }




}
