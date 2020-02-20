import java.util.ArrayList;

public class Hub {

    private ArrayList<Library> libraries;

    public Hub(ArrayList<Library> libraries) {
        this.libraries = libraries;
    }

    public ArrayList<Library> getLibraries() {
        return libraries;
    }
}
