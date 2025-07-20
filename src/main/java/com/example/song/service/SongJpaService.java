/*
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 */

// Write your code here
package com.example.song.service;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.stereotype.Service;
 import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.song.repository.SongRepository;
import com.example.song.repository.SongJpaRepository;
import com.example.song.model.Song;

@Service
public class SongJpaService implements SongRepository{

    @Autowired
    public SongJpaRepository songJpaRepository;

    @Override
    public ArrayList<Song> getSongs(){
        List<Song> songList = songJpaRepository.findAll();
        return new ArrayList<>(songList);
    }
}