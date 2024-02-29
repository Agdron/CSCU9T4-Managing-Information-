public class Music extends Projects {
    private String genre;

    public Music(double projectID, String projectName, String projectType, String projectDate, String projectLocation,
                 double projectCost, double priceToCustomer, String sizeOfVenue, double projectDuration,
                 String durationUnits, String genre)
    {
        super(projectID, projectName, projectType, projectDate, projectLocation, projectCost, priceToCustomer,
                sizeOfVenue, projectDuration, durationUnits);

        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    @Override
    public String toString() {
        return  "Project ID: " + projectID +
                "/ Project Name: " + projectName +
                "/ Type: " + projectType + '\n' +
                "/ Date: " + projectDate +
                "/ Location: " + projectLocation +
                "/ Cost: " + projectCost +
                "/ Price to Customer: " + priceToCustomer +
                "/ Venue Size: " + sizeOfVenue + '\n' +
                "/ Duration: " + projectDuration + ' ' + durationUnits +
                "/ Genre: " + genre + '\n'+'\n';
    }
}
