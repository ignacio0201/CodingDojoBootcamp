package com.codingdojo.lookify.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

import jakarta.validation.Valid;

@Controller
public class SongController {

	private final SongService songService;
	
	public SongController(SongService songService) {
		this.songService = songService;
		}
	
	//VIEWS
	//Show view welcome index OK
	@GetMapping("/")
	public String showIndex() {
		return "index.jsp";
	}
	
	//Show view all songs OK, add new, top songs, search artists, delete OK
	@GetMapping("/dashboard")
	public String showDashboard(Model model) {
		List<Song> allSongs = songService.allSongs();
		model.addAttribute("allSongs", allSongs);
		return "dashboard.jsp";
	}
	
	//Show view find songs by artist searched
	@GetMapping("/search")
	public String showSongsByArtistSearched(
			@RequestParam("artist") String artist, Model model) {
		List<Song> songsByArtist = songService.findSongByArtist(artist);
		model.addAttribute("songsByArtist", songsByArtist);
		model.addAttribute("artist", artist);
		return "search.jsp";
	}
	
	//Show view a song specific OK
	@GetMapping("/songs/{id}")
	public String findSongById(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
			model.addAttribute("song", song);
			return "details.jsp";
	}
	
	//Show view add song OK
	@GetMapping("/songs/new")
	public String showAddSong(@ModelAttribute("newSong") Song newSong) {
		return "addsong.jsp";
	}
	
	//Show view top 10
	@GetMapping("/search/topTen")
	public String showTopTen(Model model) {
		model.addAttribute("topTenList", songService.findTopTen());
		return "topten.jsp";
	}
	
	//--------------------------------------------------//
	
	//Create a new song 
	@PostMapping("/create/song")
	public String createSong(@Valid @ModelAttribute("newSong") Song newSong, BindingResult result) {
		if (result.hasErrors()) {
			return "addsong.jsp";
		} else {
			songService.createSong(newSong);
			return "redirect:/dashboard";
		}
	}
	
	//Delete song OK
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
				
}


// Show view edit
//@GetMapping("/languages/edit/{id}")
//public String edit(@PathVariable("id") Long id, Model model) {
//	Song language = songService.findSong(id);
//	model.addAttribute("language", language);
//	return "/languages/edit.jsp";
//}
		
//Update song 
//@PutMapping("/languages/{id}")
//public String update(@Valid @ModelAttribute("language") Song language, BindingResult result) {
//    if (result.hasErrors()) {
//        return "/languages/edit.jsp";
//    } else {
//    	songService.updateSong(language);
//        return "redirect:/languages";
//    }
//}
