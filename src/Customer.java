import java.util.ArrayList;

class Customer {
    private int causeConflict = 0;

    private String name;

    private ArrayList<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    };

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String getStatement() {

        double totalPrice = 0;
        int frequentRenterPoints = 0;
        StringBuilder stringBuilder = new StringBuilder("Rental Record for");
        stringBuilder.append(getName());
        stringBuilder.append("\n");
        for (Rental each : this.rentals) {
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;
            // show figures for this rental
            stringBuilder.append("\t");
            stringBuilder.append(each.getMovie().getTitle());
            stringBuilder.append("\t");
            stringBuilder.append(each.getCharge());
            stringBuilder.append("\n");
            totalPrice += each.getCharge();
        }
        // add footer lines
        stringBuilder.append("Amount owed is " + String.valueOf(totalPrice) + "\n");
        stringBuilder.append("You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points");
        return stringBuilder.toString();
    }

}
