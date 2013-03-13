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
        String string = customer.getStatement();
        Assert.assertTrue(string.contains(name));
        Assert.assertTrue(string.contains(title));
        Assert.assertTrue(string.contains("9.0"));
    }

    public void testStatementBranches() {
        Customer customer = new Customer("Adams, Daryl");
        customer.addRental(new Rental(new Movie("Title1", 0), 2));
        customer.addRental(new Rental(new Movie("Title2", 1), 2));
        customer.addRental(new Rental(new Movie("Title3", 2), 2));
        customer.getStatement();
    }

    public void testStatementException() {
        boolean caughtExpecption = false;
        Customer customer = new Customer("Adams, Daryl");
        customer.addRental(new Rental(new Movie("Title1", 3), 2));
        try {
            customer.getStatement();
        }
        catch (IllegalArgumentException e) {
            caughtExpecption = true;
        }
        Assert.assertTrue(caughtExpecption);
    }
}
