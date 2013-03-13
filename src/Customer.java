import java.util.ArrayList;

class Customer {
    private String _name;

    private ArrayList<Rental> _rentals = new ArrayList<Rental>();

    public Customer(String name) {
        _name = name;
    };

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String getStatement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder stringBuilder = new StringBuilder("Rental Record for");
        stringBuilder.append(getName());
        stringBuilder.append("\n");
        for (Rental each: this._rentals) {
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
            totalAmount += thisAmount;
        }
        // add footer lines
        stringBuilder.append("Amount owed is " + String.valueOf(totalAmount) + "\n");
        stringBuilder.append("You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points");
        return stringBuilder.toString();
    }
}
