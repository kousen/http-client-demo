package astro.json;

import java.util.List;

public class AstroResponse {
    private String message;
    private Integer number;
    private List<Assignment> people;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Assignment> getPeople() {
        return people;
    }

    public void setPeople(List<Assignment> people) {
        this.people = people;
    }
}
