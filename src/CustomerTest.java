import junit.framework.Assert;
import junit.framework.TestCase;

public class CustomerTest extends TestCase {

    public void testCustomer() {
        String name = "Doe, John";
        Customer customer = new Customer(name);
        Assert.assertEquals(name, customer.getName());
    }

    public void testAddRental() {
        String name = "Doe, John";
        Customer customer = new Customer(name);
        String title = "Fletch";
        int priceCode = 1;
        Movie movie = new Movie(title, priceCode);
        int daysRented = 3;
        Rental rental = new Rental(movie, daysRented);
        customer.addRental(rental);
        // Nothing public to test
    }

    public void testStatement() {
        String name = "Doe, John";
        Customer customer = new Customer(name);
        String title = "Fletch";
        int priceCode = 1;
        Movie movie = new Movie(title, priceCode);
        int daysRented = 3;
        Rental rental = new Rental(movie, daysRented);
        customer.addRental(rental);
        String string = customer.statement();
        System.out.println(string);
        Assert.assertTrue(string.contains(name));
        Assert.assertTrue(string.contains(title));
        Assert.assertTrue(string.contains("9.0"));
    }

}
