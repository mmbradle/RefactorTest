public class Movie {
    public static final int CHILDRENS = 2;

    public static final int REGULAR = 0;

    public static final int NEW_RELEASE = 1;

    private String title;

    private int priceCodeAsInt;

    public Movie(final String title, final int priceCode) {
        this.title = title;
        this.priceCodeAsInt = priceCode;
    }

    public int getPriceCode() {
        return this.priceCodeAsInt;
    }

    public void setPriceCode(final int arg) {
        this.priceCodeAsInt = arg;
    }

    public String getTitle() {
        return this.title;
    }
}
