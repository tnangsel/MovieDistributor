import java.util.ArrayList;
import java.util.List;

public class MovieCatalog {
    private List<Movie> movies;
    private List<Distributor> distributors;

    public MovieCatalog() {
        this.movies = new ArrayList<>();
        this.distributors = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public boolean removeMovie(String movieName) {
        for (Movie movie : movies) {
            if (movie.getName().equalsIgnoreCase(movieName)) {
                Distributor distributor = movie.getDistributor();
                if (distributor != null) {
                    distributor.removeMovie(movie);
                }
                movies.remove(movie);
                return true;
            }
        }
        return false;
    }

    public Movie getMovie(String movieName) {
        for (Movie movie : movies) {
            if (movie.getName().equalsIgnoreCase(movieName)) {
                return movie;
            }
        }
        return null;
    }

    public void addDistributor(Distributor distributor) {
        distributors.add(distributor);
    }

    public Distributor getDistributor(String distributorName) {
        for (Distributor distributor : distributors) {
            if (distributor.getName().equalsIgnoreCase(distributorName)) {
                return distributor;
            }
        }
        return null;
    }

    public List<Movie> getAllMovies() {
        return new ArrayList<>(movies);
    }

    public List<Distributor> getAllDistributors() {
        return new ArrayList<>(distributors);
    }
}

