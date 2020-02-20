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
        }
        return updateLibrary;
    }

    private Integer getIndexOfBest(ArrayList<Integer> scorePerLibrary) {
        Integer indexOfBest = scorePerLibrary.get(0);
        for (int i = 0; i < scorePerLibrary.size(); i++) {
            if(indexOfBest < scorePerLibrary.get(i)) {
                indexOfBest = scorePerLibrary.get(i);
            }
        }
        return indexOfBest;
    }

}
