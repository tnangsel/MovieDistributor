import java.util.List;

class DistributorManager implements DistributorManagement {
    private final List<Distributor> distributors;

    public DistributorManager(List<Distributor> distributors) {
        this.distributors = distributors;
    }

    @Override
    public void addDistributor(String name) {
        Distributor distributor = new Distributor(name);
        distributors.add(distributor);
    }

    @Override
    public void distributorMovieDetails(String distributorName, String movieName) {
        Distributor distributor = getDistributorByName(distributorName);
        if (distributor != null) {
            int numberOfMovies = distributor.getNumberOfMovies(movieName);
            System.out.println("Distributor: " + distributor.getName());
            System.out.println("Number of Movies: " + numberOfMovies);
            System.out.println("Movies: " + distributor.getMovies());
        }
    }

    private Distributor getDistributorByName(String distributorName) {
        for (Distributor distributor : distributors) {
            if (distributor.getName().equalsIgnoreCase(distributorName)) {
                return distributor;
            }
        }
        return null;
    }
}
