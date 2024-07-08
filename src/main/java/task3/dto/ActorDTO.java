package task3.dto;

import task3.models.Movie;
import task3.models.PhoneNumber;

import java.util.List;

public class ActorDTO {
    private int id;
    private String name;

    public ActorDTO() {
    }

    public ActorDTO(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
