package com.example.moviefacts.service.controller;

import com.example.moviefacts.service.repository.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Random;

/**
 * @Author Mohammad Adel Murtada
 */
@RestController
public class MovieController {

  @GetMapping("/")
  public String defaultPage(){
    return "Velkommen til Min side, Lad os kigge på nogle film";
  }

  @GetMapping("/getFirst")
  public String getFirst(){
    MovieRepository movieRepository = new MovieRepository();
    try {
      movieRepository.readFile();
    } catch (IOException e) {
      System.out.println("fejl");
    }
    return movieRepository.getMovieList().get(0).toString().replace("[","").replace("]","").replace(",","");
  }

  @GetMapping("/findAll")
  public String findAll()  {
  MovieRepository movieRepository = new MovieRepository();
    try {
    movieRepository.readFile();
  } catch (IOException e) {
    System.out.println("fejl");
  }
  return movieRepository.getMovieList().toString().replace("[","").replace("]","").replace(",","");
}

  @GetMapping("/getRandom")
  public String getRandom(){
    MovieRepository movieRepository = new MovieRepository();
    try {
      movieRepository.readFile();
    } catch (IOException e) {
      System.out.println("fejl");
    }
    Random rand = new Random();
    int randomNumber = rand.nextInt(movieRepository.getMovieList().size());
    return movieRepository.getMovieList().get(randomNumber).toString().replace("["," ").replace("]"," ").replace(","," ");
  }

  @GetMapping("/getTenSortByPopularity")
  public String sortedByPopularity(){
    MovieRepository movieRepository = new MovieRepository();
    try {
      movieRepository.readFile();
    } catch (IOException e) {
      System.out.println("fejl");
    }
    return movieRepository.movieSortedList();
  }
  @GetMapping("/howManyWonAnAward")
  public String howManyWon(){
    MovieRepository movieRepository = new MovieRepository();
    try {
      movieRepository.readFile();
    } catch (IOException e) {
      System.out.println("fejl");
    }
    return movieRepository.awardWinningMovies();
  }

  @GetMapping("/filter")
  public String filterCharAmount(String character, int amount){
    MovieRepository movieRepository = new MovieRepository();
    try {
      movieRepository.readFile();
    } catch (IOException e) {
      System.out.println("fejl");
    }
    return movieRepository.filterByChar(character,amount);
  }

  @GetMapping("longest")
  public String longestGenre(String genre1, String genre2){
    MovieRepository movieRepository = new MovieRepository();
    try {
      movieRepository.readFile();
    } catch (IOException e) {
      System.out.println("fejl");
    }
    return movieRepository.longestGenre(genre1,genre2);
  }



}
