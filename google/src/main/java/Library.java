import java.util.ArrayList;

public class Library {

    private Integer nbrOfBooks;
    private ArrayList<Book> books;
    private Integer timeToSignUp;
    private Integer capacityPerDay;
    private Integer name;
    private Boolean isSignup;
    private ArrayList<Book> scanBooks;

    public Library() {
    }

    public Library(Integer nbrOfBooks, Integer timeToSignUp, Integer capacityPerDay, Integer name) {
        this.nbrOfBooks = nbrOfBooks;
        this.books = new ArrayList<>();
        this.timeToSignUp = timeToSignUp;
        this.capacityPerDay = capacityPerDay;
        this.isSignup = false;
        this.scanBooks = new ArrayList<>();
        this.name = name;
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

    public Boolean getSignup() {
        return isSignup;
    }

    public ArrayList<Book> getScanBooks() {
        return scanBooks;
    }

    public Integer getName() {
        return name;
    }

    public void setScanBooks(ArrayList<Book> scanBooks) {
        this.scanBooks = scanBooks;
    }

    private int getMax(ArrayList<Book> list){
        int max = Integer.MIN_VALUE;
        int indexMax = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getScore() > max){
                max = list.get(i).getScore();
                indexMax = i;
            }
        }
        return indexMax;
    }

    public ArrayList<Book> sortBooks (ArrayList<Book> books) {
        ArrayList<Book> booksTmp = books;
        ArrayList<Book> booksReturn = new ArrayList<>();

        for (int i = 0; i < books.size(); i++) {
            int indexMax = this.getMax(booksTmp);
            booksReturn.add(books.get(indexMax));
            booksTmp.remove(books.get(indexMax));
        } 
        return booksReturn;
    }


    public int maxScore (ArrayList<Book> books, Integer nbrScanBook) {
        int score = 0;
        for (int i = 0; i < nbrScanBook; i++) {
            Book book = books.get(i);
            score += book.getScore();
        }
        return score;
    }

}
