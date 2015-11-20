package hello;

import java.util.List;
import java.util.ArrayList;

public class Bautura {
  private String name;
  private int id;
  private int alchoolProof;

  public Bautura() {}

  public Bautura(int id, String name,int alchoolProof) {
      this.name = name;
      this.id = id;
      this.alchoolProof=alchoolProof;
  }

  void setBauturaName(String name){
      this.name = name;
  }
  void setBauturaAlchoolProof(int alchoolProof){
      this.alchoolProof=alchoolProof;
  }
  public String getName() {
      return this.name;
  }

  public int getId() {
    return this.id;
  }
  public int getAlchoolProof(){
      return alchoolProof;
  }
}