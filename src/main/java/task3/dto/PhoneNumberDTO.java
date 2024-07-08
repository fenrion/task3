package task3.dto;

public class PhoneNumberDTO {
    private int id;
    private String number;

    public PhoneNumberDTO() {
    }

    public PhoneNumberDTO(int id, String number) {
        this.id = id;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "PhoneNumberDTO{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
