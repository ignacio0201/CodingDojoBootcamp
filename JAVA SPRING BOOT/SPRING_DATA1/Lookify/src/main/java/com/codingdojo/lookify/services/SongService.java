package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.SongRepository;

@Service
public class SongService {

	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	// Return all songs
	public List<Song> allSongs() {
		return songRepository.findAll();
	}

	// Create a song
	public Song createSong(Song song) {
		return songRepository.save(song);
	}

	// Find info song by id
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	
	// Find song by artist
	public List<Song> findSongByArtist(String artist) {
		List<Song> songsByArtist = songRepository.findByArtistContaining(artist);
		if(!songsByArtist.isEmpty()) {
			return songsByArtist;
		}else {
			return null;
		}	
	}
	
	// Find top ten 
	public List<Song> findTopTen(){
		return songRepository.findTopTenByRatingDESC();
	}
	
	//Update song
//	public Song updateSong(Long id, String name, String creator, String currentVersion) {
//		Optional<Song> optionalSong = songRepository.findById(id);
//		if(optionalSong.isPresent()) {
//			optionalSong.get().setName(name);
//			optionalSong.get().setCreator(creator);
//			optionalSong.get().setCurrentVersion(currentVersion);
//		}
//		return songRepository.save(optionalSong.get());
//	}
			
	//Update song 2
	public Song updateSong(Song song) {
		return songRepository.save(song);
	}
			
	//Delete song
	public void deleteSong(Long id) {
			songRepository.deleteById(id);
	}
	
	
}
