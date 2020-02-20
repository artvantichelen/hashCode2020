import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        File file = new File(args[0]);

        try {
            FileReader fileReader = new FileReader(file);
            PrintWriter writer = new PrintWriter(args[1]);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            Integer lineNbr = 1;
            String[] tabString = line.split(" ");
            ScanPlanning scanPlanning = new ScanPlanning(Integer.parseInt(tabString[0]), Integer.parseInt(tabString[1]), Integer.parseInt(tabString[2]));
            ArrayList<Library> libraries = new ArrayList<>();
            ArrayList<Book> books = new ArrayList<>();
            while (line != null) {
                if(lineNbr == 2) {
                    String[] tabScoring = line.split("");
                    for (int i = 0; i < tabScoring.length; i++) {
                        Book book = new Book(i, Integer.parseInt(tabScoring[i]));
                        books.add(book);
                    }
                }
                Library library = null;
                if(lineNbr > 2 && lineNbr % 2 != 0) {
                    String[] tabLibrary = line.split("");
                    for (int i = 0; i < tabLibrary.length; i++) {
                        library = new Library(Integer.parseInt(tabLibrary[0]), Integer.parseInt(tabLibrary[1]), Integer.parseInt(tabLibrary[2]));
                    }
                }
                if(lineNbr > 2 && lineNbr % 2 == 0) {
                    String[] tabBook = line.split("");
                    ArrayList<Book> booksForlibrary = new ArrayList<>();
                    for (int i = 0; i < tabBook.length; i++) {
                        booksForlibrary.add(books.get(Integer.parseInt(tabBook[i])));
                    }
                    library.setBooks(booksForlibrary);
                    libraries.add(library);
                }
                line = bufferedReader.readLine();
                lineNbr++;
            }
            writer.close();
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
