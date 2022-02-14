package com.example.moviefacts.service.model;

import java.util.Scanner;

/**
 * @Author Mohammad Adel Murtada
 */
public class Movie implements Comparable{
  int year;
  int length;
  String title;
  String subject;
  int popularity;
  String awards;

  public Movie(){

  }

  public void setDataFromLine(String line){
    Scanner sc = new Scanner(line).useDelimiter(";");
    year = sc.nextInt();
    length = sc.nextInt();
    title = sc.next();
    subject = sc.next();
    popularity = sc.nextInt();
    awards = sc.next();

  }


  @Override
  public String toString() {
    return "Movie; year: " + year +"; Length: " +length
        + "; Title: " + title + "; Subject: " + subject
        + "; Popularity: " + popularity + "; Awards: " + awards
        +"\n\n";
  }

  @Override
  public int compareTo(Object o) {
    if (popularity>((Movie) o).popularity) {
      return -1;
    }if (popularity<((Movie) o).popularity){
      return 1;
    }else
    return 0;
  }

  public String getAwards() {
    return awards;
  }

  public int getLength() {
    return length;
  }
}
