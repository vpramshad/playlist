package com.ramshad.playlist.repository;

import com.ramshad.playlist.entity.PlaylistEntity;
import org.springframework.data.repository.CrudRepository;

public interface PlaylistRepository extends CrudRepository<PlaylistEntity,Long> {

    PlaylistEntity save(PlaylistEntity entity);


}
