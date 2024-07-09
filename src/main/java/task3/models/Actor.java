package task3.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Actor entity
 * relation:
 * Many to Many (Movie)
 * One to Many (PhoneNumber)
 */
@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @Column(name = "act_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 1, max = 100, message = "Имя должно быть от 1 до 100 символов длиной")
    @Column(name = "act_name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "actors_movies",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movies_id")
    )
    private List<Movie> movieList;
    @OneToMany(mappedBy = "actor",fetch = FetchType.LAZY)
    private List<PhoneNumber> phoneNumberList;

    public Actor() {
    }

    public Actor(int id, String name, List<Movie> movieList, List<PhoneNumber> phoneNumberList) {
        this.id = id;
        this.name = name;
        this.movieList = movieList;
        this.phoneNumberList = phoneNumberList;
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

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public List<PhoneNumber> getPhoneNumberList() {
        return phoneNumberList;
    }

    public void setPhoneNumberList(List<PhoneNumber> phoneNumberList) {
        this.phoneNumberList = phoneNumberList;
    }

    @Override
    public String
    toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
