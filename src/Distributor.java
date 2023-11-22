import java.util.ArrayList;
import java.util.List;

class Distributor {
    private String name;
    private List<Movie> movies;

    public Distributor(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
        movie.setDistributor(this);
    }

    public void removeMovie(Movie movie) {
        movies.remove(movie);
        movie.setDistributor(null);
    }

    public int getNumberOfMovies(String movieName) {
        long count = movies.stream().filter(movie -> movie.getName().equalsIgnoreCase(movieName)).count();
        return (int) count;
    }

    @Override
    public String toString() {
        List<String> movieNames = new ArrayList<>();
        for (Movie movie : movies) {
            movieNames.add(movie.getName());
        }
        return "Distributor [name=" + name + ", movies=" + movieNames + "]";
    }
}