import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    private Integer age;
    private String city;

    Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
        this.city = personBuilder.city;
    }
//    public Person(String name, String surname) {
//        this.name = getName();
//        this.surname = getSurname();
//    }
//
//    public Person(String name, String surname, Integer age, String city) {
//        this.name = name;
//        this.surname = surname;
//        this.age = age;
//        this.city = city;
//    }

    public boolean hasAge() {
        return age != null;
    }

    public boolean hasAddress() {
        return city != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        if (!hasAge()) {
            throw new IllegalArgumentException("Не указан возраст!");
        }
        return age;
    }

    public String getAddress() {
        if (hasAddress()) {
            return city;
        }
        throw new NoSuchElementException("No city");
    }

    public void setAddress(String city) {
        this.city = city;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    public PersonBuilder newChildBuilder(int age) {
        return new PersonBuilder()
                .setSurname(getSurname())
                .setAddress(getAddress())
                .setAge(age);
    }


    @Override
    public String toString() {
        return name + " " + surname + ", " + getAge() + ", " + getAddress();
    }

}
