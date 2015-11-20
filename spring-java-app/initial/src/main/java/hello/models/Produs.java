package hello;

import java.util.List;
import java.util.ArrayList;

public class Produs {
  private String name;
  private int id;
  private int protein;

  public Produs() {}

  public Produs(int id, String name,int protein) {
      this.name = name;
      this.id = id;
      this.protein=protein;
  }
   void setProductName(String name){
      this.name = name;
  }
   void setProductProtein(int protein){
      this.name = name;
  }
  public String getName() {
      return this.name;
  }

  public int getId() {
    return this.id;
  }
  public int getProtein() {
    return this.protein;
  }
}