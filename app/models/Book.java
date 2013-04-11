package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.db.ebean.Model;

@Entity
public class Book extends Model {
  private static final long serialVersionUID = -894164648973164897L;
  @Id
  public Long id;
  public String name;
  public String edition;
  public Long isbn;
  public Long priceNew;  //Representation in dollars (Don't use floats or doubles)
  @OneToMany(mappedBy="book", cascade=CascadeType.ALL)
  public List<Offer> offers = new ArrayList<>();
  @OneToMany(mappedBy="book", cascade=CascadeType.ALL)
  public List<Request> requests = new ArrayList<>();

  public Book(String name, String edition, Long isbn, Long priceNew) {
    this.name = name;
    this.edition = edition;
    this.isbn = isbn;
    this.priceNew = priceNew;
  }
  
  /* Clears elements from offers */
  public void clearOffers() {
    for(Offer offer: offers) {
      offer.delete();
    }
  }
  
  /* Clears elements from requests */
  public void clearRequests() {
    for(Request request: requests) {
      request.delete();
    }
  }
 
  public static Finder<Long, Book> find() {
    return new Finder<Long, Book>(Long.class, Book.class);
  }
}
