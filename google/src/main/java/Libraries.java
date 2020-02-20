import java.util.ArrayList;

public class Libraries {

    private ArrayList<Book> books;
    private Integer timeToSignUp;
    private Integer capacityPerDay;

    public Libraries(ArrayList<Book> books, Integer timeToSignUp, Integer capacityPerDay) {
        this.books = books;
        this.timeToSignUp = timeToSignUp;
        this.capacityPerDay = capacityPerDay;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public Integer getTimeToSignUp() {
        return timeToSignUp;
    }

    public Integer getCapacityPerDay() {
        return capacityPerDay;
    }

}
