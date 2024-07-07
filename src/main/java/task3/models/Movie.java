package task3.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Movie entity
 * relation:
 * Many to Many(Actor)
 */
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @Column(name = "id_mov")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Название фильма не должно быть пустым")
    @Size(min = 1, max = 100, message = "Навание должно быть от 1 до 100 символов длиной")
    @Column(name = "name_mov")
    private String name;
    @ManyToMany(mappedBy = "movieList")
    private List<Actor> actorList;

    public Movie() {
    }

    public Movie(int id, String name, List<Actor> actorList) {
        this.id = id;
        this.name = name;
        this.actorList = actorList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }
}
