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

    @Override
    public Song addSong(Song song){
        songJpaRepository.save(song);
        return song;
    }

    @Override
    public Song getSongById(int songId){
        Song song = songJpaRepository.findById(songId).get();
        if(song!=null){
            return song;
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song updateSong(int songId,Song song){
        try{
            Song existingSong = getSongById(songId);
            if(song.getSongName()!=null){
                existingSong.setSongName(song.getSongName());
            }
            if(song.getLyricist()!=null){
                existingSong.setLyricist(song.getLyricist());
            }
            if(song.getSinger()!=null){
                existingSong.setSinger(song.getSinger());
            }
            if(song.getMusicDirector()!=null){
                existingSong.setMusicDirector(song.getMusicDirector());
            }
            return existingSong;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}