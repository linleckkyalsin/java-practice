import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class User {
    private final String name;
    private final LocalDate birthdate;


    public User(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Integer getAge(LocalDate currentDate) {
        return Period.between(this.getBirthdate(), currentDate).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(birthdate, user.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthdate);
    }
}
