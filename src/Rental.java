class Rental {
    private Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        movie = movie;
        daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }
    
    public double getCharge() {
        double charge = 0;
        // determine amounts for each line
        switch (this.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                charge += 2;
                if (this.getDaysRented() > 2)
                    charge += (this.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                charge += this.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                charge += 1.5;
                if (this.getDaysRented() > 3)
                    charge += (this.getDaysRented() - 3) * 1.5;
                break;
            default:
                throw new IllegalArgumentException(this.getMovie().getPriceCode() + " is not a valid priceCode");
        }
        return charge;
    }
}
