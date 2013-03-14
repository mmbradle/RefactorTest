import java.util.ArrayList;

class Customer {
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
        double total = 0;
        int frequentRenterPoints = 0;
        StringBuilder stringBuilder = new StringBuilder("Rental Record for");
        stringBuilder.append(getName());
        stringBuilder.append("\n");
        for (Rental each: this.rentals) {
            double thisAmount = 0;
            // determine amounts for each line
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
                default:
                    throw new IllegalArgumentException(each.getMovie().getPriceCode() + " is not a valid priceCode");
            }
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
                frequentRenterPoints++;
            // show figures for this rental
            stringBuilder.append("\t"); 
            stringBuilder.append(each.getMovie().getTitle());
            stringBuilder.append("\t");
            stringBuilder.append(thisAmount);
            stringBuilder.append("\n");
            total += thisAmount;
        }
        // add footer lines
        stringBuilder.append("Amount owed is " + String.valueOf(total) + "\n");
        stringBuilder.append("You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points");
        return stringBuilder.toString();
    }
}
