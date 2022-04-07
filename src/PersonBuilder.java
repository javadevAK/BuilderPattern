public class PersonBuilder {

    protected String name;
    protected String surname;
    public Integer age;
    public String city;


    public PersonBuilder setName(String name) {
        this.name =name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(Integer age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.city = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Не заполнены поля обязательные параметры: name и surname!");
        }
        return new Person(this);
    }

}
