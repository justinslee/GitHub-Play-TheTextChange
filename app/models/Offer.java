package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Offer extends Model {
  private static final long serialVersionUID = -244164648973164897L;
  @Id
  public Long id;
  public String condition;
  public Long price;
  @ManyToOne//(cascade=CascadeType.ALL)
  public Student student;
  @ManyToOne//(cascade=CascadeType.ALL)
  public Book book;
  
  public Offer(String condition, Long price) {
    this.condition = condition;
    this.price = price;
  }
 
  public static Finder<Long, Offer> find() {
    return new Finder<Long, Offer>(Long.class, Offer.class);
  }
  

}
