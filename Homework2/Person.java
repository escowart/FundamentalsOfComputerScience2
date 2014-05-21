// assignment 2
// pair 027
// Cowart, Edwin
// escowart
// Bachiri, Zacharia
// bachiri

public class Person {
    String name;
    int age;
    String gender;
    Address address;

    Person(String name, int age, String gender, Address address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    /*
     * Template ... this.name ... ... this.age ... ... this.gender ... ...
     * this.address ...
     */

    // Is this person from the same city as the given person?
    boolean sameCity(Person other) {
        return this.address.city.equals(other.address.city) &&
                this.address.state.equals(other.address.state);
    }

    // Is this person from the same state but from a different
    // city from the given person?
    boolean sameStateOnly(Person other) {
        return this.address.state.equals(other.address.state)
                && !this.sameCity(other);
    }

}
