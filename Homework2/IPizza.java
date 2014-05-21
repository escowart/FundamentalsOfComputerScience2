// assignment 2
// pair 027
// Cowart, Edwin
// escowart
// Bachiri, Zacharia
// bachiri

interface IPizza {
}

class Fancy implements IPizza {
    IPizza base;
    String topping;

    public Fancy(IPizza base, String topping) {
        this.base = base;
        this.topping = topping;
    }

}

class Plain implements IPizza {

    String crust;
    String cheese;

    public Plain(String crust, String cheese) {
        this.crust = crust;
        this.cheese = cheese;
    }

}
