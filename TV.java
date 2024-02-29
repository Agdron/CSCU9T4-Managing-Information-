public class TV extends Projects{
    private String network;

    public TV(double projectID, String projectName, String projectType, String projectDate, String projectLocation,
              double projectCost, double priceToCustomer, String sizeOfVenue, double projectDuration,
              String durationUnits, String network)
    {
        super(projectID, projectName, projectType, projectDate, projectLocation, projectCost, priceToCustomer,
                sizeOfVenue, projectDuration, durationUnits);

        this.network = network;
    }

    public String getNetwork() {
        return network;
    }
    public void setNetwork(String network) {
        this.network = network;
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
                "/ Network: " + network + '\n'+'\n';
    }
}
