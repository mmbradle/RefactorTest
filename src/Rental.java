class Rental {
    private Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return this.daysRented;
    }

    public Movie getMovie() {
        return this.movie;
    }
    
    public double getCharge() {
        double charge = 0;
        // determine amounts for each line
        switch (this.movie.getPriceCode()) {
            case Movie.REGULAR:
                charge += 2;
                if (this.daysRented > 2)
                    charge += (this.daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                charge += this.daysRented * 3;
                break;
            case Movie.CHILDRENS:
                charge += 1.5;
                if (this.daysRented > 3)
                    charge += (this.daysRented - 3) * 1.5;
                break;
            default:
                throw new IllegalArgumentException(this.movie.getPriceCode() + " is not a valid priceCode.");
        }
        return charge;
    }
    
    public int getFrequentRenterPoints() {
        // add bonus for a two day new release rental
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
