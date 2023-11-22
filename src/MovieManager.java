import java.util.List;

class MovieManager implements MovieManagement {
    private final List<Movie> movies;
    private final List<Distributor> distributors;

    public MovieManager(List<Movie> movies, List<Distributor> distributors) {
        this.movies = movies;
        this.distributors = distributors;
    }

    @Override
    public void addMovie(String name, String directorsName) {
        Movie movie = new Movie(name, directorsName);
        movies.add(movie);
    }

    @Override
    public void removeMovie(String movieName) {
        Movie movieToRemove = null;
        for (Movie movie : movies) {
            if (movie.getName().equalsIgnoreCase(movieName)) {
                movieToRemove = movie;
                break;
            }
        }

        if (movieToRemove != null) {
            Distributor distributor = movieToRemove.getDistributor();
            if (distributor != null) {
                distributor.removeMovie(movieToRemove);
            }
            movies.remove(movieToRemove);
        }
    }

    @Override
    public void setMovieEarnings(String movieName, double earnings) {
        Movie movie = getMovieByName(movieName);
        if (movie != null) {
            movie.addToEarnings(earnings);
        }
    }

    @Override
    public void setDistributor(String movieName, String distributorName) {
        Movie movie = getMovieByName(movieName);
        if (movie != null) {
            Distributor distributor = getDistributorByName(distributorName);
            if (distributor == null) {
                distributor = new Distributor(distributorName);
                distributors.add(distributor);
            }
            distributor.addMovie(movie);
        }
    }

    @Override
    public void displayMovieDetails() {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    private Movie getMovieByName(String movieName) {
        for (Movie movie : movies) {
            if (movie.getName().equalsIgnoreCase(movieName)) {
                return movie;
            }
        }
        return null;
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

