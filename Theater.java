public class Theater extends Projects  {

    private String playwright;

    public Theater(double projectID, String projectName, String projectType, String projectDate, String projectLocation,
                   double projectCost, double priceToCustomer, String sizeOfVenue, double projectDuration,
                   String durationUnits, String playwright)
    {
        super(projectID, projectName, projectType, projectDate, projectLocation, projectCost, priceToCustomer,
                sizeOfVenue, projectDuration, durationUnits);

        this.playwright = playwright;
    }

    public String getPlaywright() {
        return playwright;
    }
    public void setPlaywright(String playwright) {
        this.playwright = playwright;
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
                "/ Playwright: " + playwright + '\n'+'\n';
    }
}
