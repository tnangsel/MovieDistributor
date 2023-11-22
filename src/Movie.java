class Movie {
    private String name;
    private String directorsName;
    private Distributor distributor;
    private double earnings;

    public Movie(String name, String directorsName) {
        this.name = name;
        this.directorsName = directorsName;
        this.earnings = 0;
    }

    public String getName() {
        return name;
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public double getEarnings() {
        return earnings;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    public void addToEarnings(double amount) {
        this.earnings += amount;
    }

    @Override
    public String toString() {
        String distributorName = (distributor != null) ? distributor.getName() : "No Distributor";
        return "Movie [name=" + name + ", directorsName=" + directorsName + ", distributor=" + distributorName
                + ", earnings=" + earnings + "]";
    }
}