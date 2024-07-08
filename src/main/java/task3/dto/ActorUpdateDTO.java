package task3.dto;

import java.util.List;

public class ActorUpdateDTO {
    private String name;
    private List<MovieDTO> movies;
    private List<PhoneNumberDTO> phoneNumbers;

    public ActorUpdateDTO() {
    }

    public ActorUpdateDTO(String name, List<MovieDTO> movies, List<PhoneNumberDTO> phoneNumbers) {
        this.name = name;
        this.movies = movies;
        this.phoneNumbers = phoneNumbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MovieDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDTO> movies) {
        this.movies = movies;
    }

    public List<PhoneNumberDTO> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumberDTO> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
