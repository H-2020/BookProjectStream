import java.time.LocalDate;
import java.util.Objects;

public class Person {
    public String firstName;
    public String lastName;
    public LocalDate dateOfBirth;


    //constructor
    public Person(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }
    //getter
    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getDateOfBirth(), person.getDateOfBirth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getDateOfBirth());
    }



    @Override
    public String toString() {
        return firstName +" "+ lastName+" "+ dateOfBirth;
    }
}