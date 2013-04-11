package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Request extends Model {
  private static final long serialVersionUID = -156164648973164897L;
  @Id
  public Long id;
  public String condition;
  public Long price;
  @ManyToOne//(cascade=CascadeType.ALL)
  public Student student;
  @ManyToOne//(cascade=CascadeType.ALL)
  public Book book;
  
  public Request(String condition, Long price) {
    this.condition = condition;
    this.price = price;
  }
 
  public static Finder<Long, Request> find() {
    return new Finder<Long, Request>(Long.class, Request.class);
  }
}