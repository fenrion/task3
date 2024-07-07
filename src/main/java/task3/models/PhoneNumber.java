package task3.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * PhoneNumber entity
 * relation:
 * Many to One (Actor)
 */
@Entity
@Table(name = "phone_nuumbers")
public class PhoneNumber {
    @Id
    @Column(name = "ph_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "actor_id", referencedColumnName = "act_id")
    private Actor actor;
    @NotEmpty(message = "Номер не должно быть пустым")
    @Size(min = 1, max = 15, message = "Номер должен быть от 1 до 15 символов длиной")
    @Column(name = "ph_number")
    private String number;

    public PhoneNumber() {
    }

    public PhoneNumber(Integer id, Actor actor, String number) {
        this.id = id;
        this.actor = actor;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
