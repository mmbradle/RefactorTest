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
}
