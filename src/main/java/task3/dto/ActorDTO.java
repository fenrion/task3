package task3.dto;

import task3.models.Movie;
import task3.models.PhoneNumber;

import java.util.List;

public class ActorDTO {
    private String name;
    //private List<Movie> movies;
    //private List<PhoneNumber> phoneNumbers;

    public ActorDTO() {
    }

    public ActorDTO(String name) {
        this.name = name;
        //this.movies = movies;
        //this.phoneNumbers = phoneNumbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ActorDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
