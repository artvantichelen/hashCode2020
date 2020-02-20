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

    private ArrayList<Library> sortLibraries (ArrayList<Library> libraries, ScanPlanning scanPlanning) {
        ArrayList<Library> tempLibrary = new ArrayList<>();
        ArrayList<Integer> scorePerLibrary = new ArrayList<>();
        for (int i = 0; i < libraries.size() ; i++) {
            Integer libraryScore = scanPlanning.getLibraryScoreByTime(scanPlanning.getNbrOfDays(), libraries.get(i));
            scorePerLibrary.add(libraryScore);
        }
        Integer indexOfBest = scorePerLibrary.get(0);
        indexOfBest = getIndexOfBest(scorePerLibrary, indexOfBest);
        for (int i = 0; i < scorePerLibrary.size(); i++) {
            indexOfBest
        }
        return tempLibrary;
    }

    private Integer getIndexOfBest(ArrayList<Integer> scorePerLibrary, Integer indexOfBest) {
        for (int i = 1; i < scorePerLibrary.size(); i++) {
            if(indexOfBest < scorePerLibrary.get(i)) {
                indexOfBest = scorePerLibrary.get(i);
            }
        }
        return indexOfBest;
    }

}
