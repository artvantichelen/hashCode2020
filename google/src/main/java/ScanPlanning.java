public class ScanPlanning {

    private Integer nbrOfBooks;
    private Integer nbrOfLibraries;
    private Integer nbrOfDays;

    public ScanPlanning(Integer nbrOfBooks, Integer nbrOfLibraries, Integer nbrOfDays) {
        this.nbrOfBooks = nbrOfBooks;
        this.nbrOfLibraries = nbrOfLibraries;
        this.nbrOfDays = nbrOfDays;
    }

    public Integer getNbrOfBooks() {
        return nbrOfBooks;
    }

    public Integer getNbrOfLibraries() {
        return nbrOfLibraries;
    }

    public Integer getNbrOfDays() {
        return nbrOfDays;
    }

    public Integer getLibraryScoreByTime (Integer deadLine, Library library) {
        Integer timeToScan = deadLine - library.getTimeToSignUp();
        Integer nbrOfDayForScanAll = library.getNbrOfBooks() / library.getCapacityPerDay();
        if (nbrOfDayForScanAll > timeToScan) {
            
        }
        return null;
    }
}
