import java.util.ArrayList;

class Customer {
    private int causeConflictRight = 0;

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

    public String htmlStatement() {
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
        for (Rental each : this.rentals) {
            // show figures for each rental
            result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
        }
        // add footer lines
        result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints())
                + "</EM> frequent renter points<P>";
        return result;
    }

    public String getStatement() {
        StringBuilder stringBuilder = new StringBuilder("Rental Record for");
        stringBuilder.append(getName());
        stringBuilder.append("\n");
        for (Rental each : this.rentals) {
            // show figures for this rental
            stringBuilder.append("\t");
            stringBuilder.append(each.getMovie().getTitle());
            stringBuilder.append("\t");
            stringBuilder.append(each.getCharge());
            stringBuilder.append("\n");
        }
        // add footer lines
        stringBuilder.append("Amount owed is " + String.valueOf(getTotalCharge()) + "\n");
        stringBuilder
                .append("You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points");
        return stringBuilder.toString();
    }

    private int getTotalFrequentRenterPoints() {
        int points = 0;
        for (Rental each : this.rentals) {
            points += each.getFrequentRenterPoints();
        }
        return points;
    }

    private double getTotalCharge() {
        double charge = 0;
        for (Rental each : this.rentals) {
            charge += each.getCharge();
        }
        return charge;
    }
}
