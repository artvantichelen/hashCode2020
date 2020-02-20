import java.util.ArrayList;

public class Hub {

    private ArrayList<Library> libraries;
    private ScanPlanning scanPlanning;
    private ArrayList<Library> librariesSort;

    public Hub(ArrayList<Library> libraries, ScanPlanning scanPlanning) {
        this.libraries = libraries;
        this.scanPlanning = scanPlanning;
        this.librariesSort = sortLibraries(libraries, scanPlanning);
    }

    public ArrayList<Library> getLibraries() {
        return libraries;
    }

    public ScanPlanning getScanPlanning() {
        return scanPlanning;
    }

    public ArrayList<Library> getLibrariesSort() {
        return librariesSort;
    }

    private ArrayList<Library> sortLibraries (ArrayList<Library> libraries, ScanPlanning scanPlanning) {
        ArrayList<Library> updateLibrary = new ArrayList<>();
        ArrayList<Integer> scorePerLibrary = new ArrayList<>();
        for (int i = 0; i < libraries.size() ; i++) {
            Integer libraryScore = scanPlanning.getLibraryScoreByTime(scanPlanning.getNbrOfDays(), libraries.get(i));
            scorePerLibrary.add(libraryScore);
        }
        Integer indexOfBest = 0;
        ArrayList<Integer> scorePerLibraryTemp = scorePerLibrary;
        for (int i = 0; i < scorePerLibrary.size(); i++) {
            indexOfBest = getIndexOfBest(scorePerLibraryTemp);
            updateLibrary.add(libraries.get(indexOfBest));
            scorePerLibraryTemp.remove(scorePerLibraryTemp.get(indexOfBest));
            for (int j = 0; j < libraries.size(); j++) {
                ArrayList<Book> bookUpdate = scanPlanning.deleteBookScanned(libraries.get(indexOfBest), libraries.get(j));
                libraries.get(i).setBooks(bookUpdate);
            }
        }
        return updateLibrary;
    }

    private Integer getIndexOfBest(ArrayList<Integer> scorePerLibrary) {
        Integer maxScore = scorePerLibrary.get(0);
        Integer indexOfBest = 0;
        for (int i = 0; i < scorePerLibrary.size(); i++) {
            if(maxScore < scorePerLibrary.get(i)) {
                indexOfBest = i;
            }
        }
        return indexOfBest;
    }

}
