package com.ramshad.playlist.service;

import com.ramshad.playlist.entity.Song;
import com.ramshad.playlist.entity.PlaylistEntity;
import com.ramshad.playlist.form.SongForm;
import com.ramshad.playlist.view.PlayListView;

import java.util.List;

public interface PlaylistService {

    //PlayListView getPlaylist(Long playListId);

    List<PlayListView> loadPlaylist();

    PlayListView addPlaylist(PlaylistEntity pl);

    List<Song> addSong(SongForm form);

    List<Song> loadSongs();

    List<PlayListView> deletePlaylist(Long playlistId);
    List<Song> deleteSong(Long songId);


}
