package hello;

import java.util.List;
import java.util.ArrayList;

public class Carte {
  private String name;
  private String author;
  private int id;

  public Carte() {}

  public Carte(int id, String name,String author) {
      this.name = name;
      this.id = id;
      this.author=author;
  }

  void setCarteName(String name){
      this.name = name;
  }
  void setCarteAuthor(String author){
      this.author = author;
  }

  public String getName() {
      return this.name;
  }

  public int getId() {
    return this.id;
  }
  public String getAuthor() {
    return this.author;
  }
}