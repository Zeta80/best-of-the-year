package org.lessons.bestoftheyear.controller;

import org.lessons.bestoftheyear.Movie;
import org.lessons.bestoftheyear.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class HomeController {

    private List<Movie> getBestMovies() {
        List<Movie> bestMovies = new ArrayList<>();
        // qui aggiungi i tuoi migliori film
        bestMovies.add(new Movie(1L, "la leggenda delle Rocce Ululanti"));
        bestMovies.add(new Movie(2L, "Zeno vs Fraxi, la maledizione di Athas"));
        bestMovies.add(new Movie(3L, "Black-man, le origini di Ruvak"));
        return bestMovies;
    }
    private List<Song> getBestSongs() {
        List<Song> bestSongs = new ArrayList<>();
        // qui aggiungi le tue migliori canzoni
        bestSongs.add(new Song(1L, "Kutoa merda"));
        bestSongs.add(new Song(2L, "la ballata a Zeno"));
        bestSongs.add(new Song(3L, "immagine retrospettiva"));
        return bestSongs;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("title", "MIRKO");
        return "bestyear";
    }

    @GetMapping("/movies")
    public String getMovies(Model model) {
        List<Movie> movies = getBestMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/movies/{id}")
    public String movieDetail(@PathVariable(name = "id") int movieId, Model model){
        for(Movie m:getBestMovies()){
            if (m.getId() == movieId){
                model.addAttribute("movie", m);
            }
        }
        //richiamiamo un nuovo file template
        return "movie-detail";
    }

    @GetMapping("/songs")
    public String getSongs(Model model) {
        List<Song> songs = getBestSongs();
        model.addAttribute("songs", songs);
        return "songs";
    }

    @GetMapping("/songs/{id}")
    public String songDetail(@PathVariable(name = "id") int songId, Model model){
        for(Song s:getBestSongs()){
            if (s.getId() == songId){
                model.addAttribute("song", s);
            }
        }
        //richiamiamo un nuovo file template
        return "song-detail";
    }
}
