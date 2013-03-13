import junit.framework.TestCase;

import org.junit.Assert;

public class RentalTest extends TestCase {

    public void testRental() {
        String title = "Fletch";
        int priceCode = 1;
        Movie movie = new Movie(title, priceCode);
        int daysRented = 3;
        Rental rental = new Rental(movie, daysRented);
        Assert.assertEquals(daysRented, rental.getDaysRented());
        Assert.assertEquals(movie, rental.getMovie());
        Assert.assertEquals(title, rental.getMovie().getTitle());
        Assert.assertEquals(priceCode, rental.getMovie().getPriceCode());
    }
}
