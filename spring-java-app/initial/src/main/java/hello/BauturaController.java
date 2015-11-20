package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class BauturaController {
  private List<Bautura> bauturi = new ArrayList<Bautura>();

  BauturaController() {
    Bautura b1 = new Bautura(1, "Apa",0);
    Bautura b2 = new Bautura(2, "Bere",5);
    Bautura b3 = new Bautura(3, "Gin",45);

    bauturi.add(b1);
    bauturi.add(b2);
    bauturi.add(b3);
  }

  @RequestMapping(value="/bautura", method = RequestMethod.GET)
  public List<Bautura> index() {
    return this.bauturi;
  }

  @RequestMapping(value="/bautura/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Bautura b : this.bauturi) {
      if(b.getId() == id) {
        return new ResponseEntity<Bautura>(b, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/bautura/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Bautura b : this.bauturi) {
      if(b.getId() == id) {
        this.bauturi.remove(b);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  private static int counter; 
   @RequestMapping(value="/bautura/{name},{alchoolProof}", method = RequestMethod.POST)
  public ResponseEntity createDrink(@PathVariable("name") String name,@PathVariable("alchoolProof") int alchoolProof) {
    counter=bauturi.size()+1;
    Bautura b = new Bautura(counter, name,alchoolProof);
    bauturi.add(b);     
    return new ResponseEntity<Bautura>(b, new HttpHeaders(), HttpStatus.OK);
    }

     @RequestMapping(value="/bautura/{id},{name},{alchoolProof}", method = RequestMethod.PUT)
    public ResponseEntity updateDrink(@PathVariable("id") int id, @PathVariable("name") String name,@PathVariable("alchoolProof") int alchoolProof) {
    for(Bautura b : this.bauturi) {
      if(b.getId() == id) {
            b.setBauturaName(name);
            b.setBauturaAlchoolProof(alchoolProof);
            return new ResponseEntity<Bautura>(null, new HttpHeaders(), HttpStatus.OK);
    }
  }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
 }
}