public class Film extends Projects{
    private String format;

    public Film(double projectID, String projectName, String projectType, String projectDate, String projectLocation,
                double projectCost, double priceToCustomer, String sizeOfVenue, double projectDuration,
                String durationUnits, String format)
    {
        super(projectID, projectName, projectType, projectDate, projectLocation, projectCost, priceToCustomer,
                sizeOfVenue, projectDuration, durationUnits);

        this.format = format;
    }

    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        this.format = format;
    }
    @Override
    public String toString() {
        return  "Project ID: " + projectID +
                " / Project Name: " + projectName +
                " / Type: " + projectType +  '\n' +
                " / Date: " + projectDate +
                " / Location: " + projectLocation +
                " / Cost: " + projectCost +
                " / Price to Customer: " + priceToCustomer +
                " / Venue Size: " + sizeOfVenue + '\n' +
                " / Duration: " + projectDuration + ' ' + durationUnits +
                " / Format: " + format + '\n'+'\n';
    }
}
