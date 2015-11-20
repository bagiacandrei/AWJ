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


@RestController
public class ProdusController {
  private List<Produs> produse = new ArrayList<Produs>();

  ProdusController() {
    Produs p1 = new Produs(1, "Lapte",3);
    Produs p2 = new Produs(2, "Carne",20);
    Produs p3 = new Produs(3, "Paine",7);
    Produs p4 = new Produs(4, "Oua",14);

    produse.add(p1);
    produse.add(p2);
    produse.add(p3);
    produse.add(p4); 
  }

  @RequestMapping(value="/produs", method = RequestMethod.GET)
  public List<Produs> index() {
    return this.produse;
  }

  @RequestMapping(value="/produs/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Produs p : this.produse) {
      if(p.getId() == id) {
        return new ResponseEntity<Produs>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/produs/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Produs p : this.produse) {
      if(p.getId() == id) {
        this.produse.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  private static int counter; 
   @RequestMapping(value="/produs/{name},{protein}", method = RequestMethod.POST)
  public ResponseEntity createProduct(@PathVariable("name") String name, @PathVariable("protein") int protein) {
    counter=produse.size()+1;
    Produs p = new Produs(counter, name, protein);
    produse.add(p);     
    return new ResponseEntity<Produs>(p, new HttpHeaders(), HttpStatus.OK);
    }

     @RequestMapping(value="/produs/{id},{name},{protein}", method = RequestMethod.PUT)
  public ResponseEntity updateProduct(@PathVariable("id") int id, @PathVariable("name") String name,@PathVariable("protein") int protein) {
    for(Produs p : this.produse) {
      if(p.getId() == id) {
            p.setProductName(name);
            p.setProductProtein(protein);
            return new ResponseEntity<Produs>(null, new HttpHeaders(), HttpStatus.OK);
    }
  }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
 }
  
}