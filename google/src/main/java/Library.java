import java.util.ArrayList;

public class Library {

    private Integer nbrOfBooks;
    private ArrayList<Book> books;
    private Integer timeToSignUp;
    private Integer capacityPerDay;

    public Library() {
    }

    public Library(Integer nbrOfBooks, Integer timeToSignUp, Integer capacityPerDay) {
        this.nbrOfBooks = nbrOfBooks;
        this.books = new ArrayList<>();
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

    public Integer getNbrOfBooks() {
        return nbrOfBooks;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
