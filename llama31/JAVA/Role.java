import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Role {
  @EmbeddedId
  private RolePK pk;

  // getters and setters
  public RolePK getPk() {
    return pk;
  }

  public void setPk(RolePK pk) {
    this.pk = pk;
  }
}

@Embeddable
public class RolePK implements Serializable {
  @Column(name = "Actor")
  private int actor;

  @Column(name = "Movie")
  private int movie;

  @Column(name = "Character")
  private int character;

  // getters and setters
  public int getActor() {
    return actor;
  }

  public void setActor(int actor) {
    this.actor = actor;
  }

  public int getMovie() {
    return movie;
  }

  public void setMovie(int movie) {
    this.movie = movie;
  }

  public int getCharacter() {
    return character;
  }

  public void setCharacter(int character) {
    this.character = character;
  }

  public static void main(String[] args) {
  }
}