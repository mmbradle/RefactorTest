import java.util.Enumeration;
import java.util.Vector;

class Customer {
    private String _name;

    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    };

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        StringBuilder stringBuilder = new StringBuilder("Rental Record for");
        stringBuilder.append(getName());
        stringBuilder.append("\n");
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();
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
