package task3.dto;

import task3.models.Movie;
import task3.models.PhoneNumber;

import java.util.List;

public class ActorOneDTO {
    private String name;
    private List<MovieDTO> movieList;
    private List<PhoneNumberDTO> phoneNumberList;

    public ActorOneDTO() {
    }

    public ActorOneDTO(String name, List<MovieDTO> movieList, List<PhoneNumberDTO> phoneNumberList) {
        this.name = name;
        this.movieList = movieList;
        this.phoneNumberList = phoneNumberList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MovieDTO> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<MovieDTO> movieList) {
        this.movieList = movieList;
    }

    public List<PhoneNumberDTO> getPhoneNumberList() {
        return phoneNumberList;
    }

    public void setPhoneNumberList(List<PhoneNumberDTO> phoneNumberList) {
        this.phoneNumberList = phoneNumberList;
    }

    @Override
    public String toString() {
        return "ActorOneDTO{" +
                "name='" + name + '\'' +
                ", movieList=" + movieList +
                ", phoneNumberList=" + phoneNumberList +
                '}';
    }
}
