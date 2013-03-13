import junit.framework.TestCase;

import org.junit.Assert;

public class MovieTest extends TestCase {

    public void testMovie() {
        String title = "Fletch";
        int priceCode = 1;
        Movie movie = new Movie(title, priceCode);
        Assert.assertEquals(title, movie.getTitle());
        Assert.assertEquals(priceCode, movie.getPriceCode());
    }
    
    public void testSetPriceCode() {
        String title = "Fletch";
        int priceCode = 1;
        Movie movie = new Movie(title, priceCode);
        movie.setPriceCode(0);
    }
}
