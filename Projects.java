public class Projects {

    protected double projectID;
    protected String projectName;
    protected String projectType;
    protected String projectDate;
    protected String projectLocation;
    protected double projectCost;
    protected double priceToCustomer;
    protected String sizeOfVenue;

    protected double projectDuration;
    protected String durationUnits;

    public Projects(double projectID, String projectName, String projectType, String projectDate, String projectLocation,
                    double projectCost, double priceToCustomer, String sizeOfVenue, double projectDuration,
                    String durationUnits) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.projectType = projectType;
        this.projectDate = projectDate;
        this.projectLocation = projectLocation;
        this.projectCost = projectCost;
        this.priceToCustomer = priceToCustomer;
        this.sizeOfVenue = sizeOfVenue;
        this.projectDuration = projectDuration;
        this.durationUnits = durationUnits;
    }

    public double getProjectID() {
        return projectID;
    }

    public void setProjectID(double projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectDate() {
        return projectDate;
    }

    public void setProjectDate(String projectDate) {
        this.projectDate = projectDate;
    }

    public String getProjectLocation() {
        return projectLocation;
    }

    public void setProjectLocation(String projectLocation) {
        this.projectLocation = projectLocation;
    }

    public double getProjectCost() {
        return projectCost;
    }

    public void setProjectCost(double projectCost) {
        this.projectCost = projectCost;
    }

    public double getPriceToCustomer() {
        return priceToCustomer;
    }

    public void setPriceToCustomer(double priceToCustomer) {
        this.priceToCustomer = priceToCustomer;
    }

    public String getSizeOfVenue() {
        return sizeOfVenue;
    }

    public void setSizeOfVenue(String sizeOfVenue) {
        this.sizeOfVenue = sizeOfVenue;
    }

    public double getProjectDuration() {
        return projectDuration;
    }

    public void setProjectDuration(double projectDuration) {
        this.projectDuration = projectDuration;
    }

    public String getDurationUnits() {
        return durationUnits;
    }

    public void setDurationUnits(String durationUnits) {
        this.durationUnits = durationUnits;
    }
}
