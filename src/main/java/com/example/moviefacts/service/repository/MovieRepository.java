package com.example.moviefacts.service.repository;

import com.example.moviefacts.service.model.Movie;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author Mohammad Adel Murtada
 */
public class MovieRepository {
   ArrayList<Movie> movieList = new ArrayList();
   ArrayList<Movie> characterList = new ArrayList<>();

  String fil = "imdb-data.csv";

  public void readFile() throws IOException{
    Scanner reader = new Scanner(new File(fil));
    while (reader.hasNext()) {
      Movie movie = new Movie();
      reader.nextLine();
      String lines = reader.nextLine();
      movie.setDataFromLine(lines);
      movieList.add(movie);
    }
  }

  public ArrayList<Movie> getMovieList() {
    return movieList;
  }

  public String movieSortedList(){
    Collections.sort(movieList);
    if (movieList.size()>10){
      return movieList.subList(0,10).toString().replace("["," ").replace("]"," ").replace(","," ");
    }else
    return movieList.toString().replace("["," ").replace("]"," ").replace(","," ");
  }

  public String awardWinningMovies(){
    int counter = 0;
    for (int i = 0; i < movieList.size(); i++){
      if (movieList.get(i).getAwards().equalsIgnoreCase("yes")){
        counter++;
      }
    }
    return ""+counter+" Movies has won an award out of " + movieList.size() + " Movies";
  }

  public String filterByChar(String character, int amount) {
    for (int i = 0; i < movieList.size(); i++) {
      if (movieList.get(i).toString().contains(character)) {
        characterList.add(movieList.get(i));
      }
    }
    if (amount > characterList.size())
      return characterList.toString();
    else
      return characterList.subList(0,amount).toString();
  }
  public String longestGenre(String genre1, String genre2){
    int counterGenre1 = 0;
    int antalGenre1 = 0;
    int counterGenre2 = 0;
    int antalGenre2 = 0;
    for (int i = 0; i < movieList.size(); i++){
      if (movieList.get(i).toString().contains(genre1)){
        antalGenre1++;
        counterGenre1 = movieList.get(i).getLength() + counterGenre1;
      }
      else if (movieList.get(i).toString().contains(genre2)){
        antalGenre2++;
        counterGenre2 = movieList.get(i).getLength() + counterGenre2;
      }
    }
    int gennemsnitGenre1 = counterGenre1 / antalGenre1;
    int gennemsnitGenre2 = counterGenre2 / antalGenre2;
    if (gennemsnitGenre1 < gennemsnitGenre2){
      return genre2 + " Har gennemsnitlig længere film";
    }else
      return genre1 + " Har gennemsnitlig længere film";
  }
}
