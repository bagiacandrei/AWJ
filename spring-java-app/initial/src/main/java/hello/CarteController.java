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
public class CarteController {
  private List<Carte> carti = new ArrayList<Carte>();

  CarteController() {
    Carte c1 = new Carte(1, "Harry Potter","J.K. Rowling");
    Carte c2 = new Carte(2, "Les Miserables","Victor Hugo");
    Carte c3 = new Carte(3, "Rascoala","Liviu Rebreanu");

    carti.add(c1);
    carti.add(c2);
    carti.add(c3);
  }

  @RequestMapping(value="/carte", method = RequestMethod.GET)
  public List<Carte> index() {
    return this.carti;
  }

  @RequestMapping(value="/carte/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Carte c : this.carti) {
      if(c.getId() == id) {
        return new ResponseEntity<Carte>(c, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/carte/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Carte c : this.carti) {
      if(c.getId() == id) {
        this.carti.remove(c);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  private static int counter; 
   @RequestMapping(value="/carte/{name},{author}", method = RequestMethod.POST)
  public ResponseEntity createBook(@PathVariable("name") String name,@PathVariable("author") String author) {
    counter=carti.size()+1;
    Carte c = new Carte(counter, name, author);
    carti.add(c);     
    return new ResponseEntity<Carte>(c, new HttpHeaders(), HttpStatus.OK);
    }

     @RequestMapping(value="/carte/{id},{name}?,{author}?", method = RequestMethod.PUT)
  public ResponseEntity updateBook(@PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("author") String author) {
    for(Carte c : this.carti) {
      if(c.getId() == id) {
            c.setCarteName(name);
            c.setCarteAuthor(author);
            return new ResponseEntity<Carte>(null, new HttpHeaders(), HttpStatus.OK);
    }
  }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
 }
}