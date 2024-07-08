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
@Table(name = "phone_numbers")
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

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneNumber that = (PhoneNumber) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (actor != null ? !actor.equals(that.actor) : that.actor != null) return false;
        return number != null ? number.equals(that.number) : that.number == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (actor != null ? actor.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }
}
