package com.ramshad.playlist.repository;

import com.ramshad.playlist.entity.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {

}
