interface MovieManagement {
    void addMovie(String name, String directorsName);

    void removeMovie(String movieName);

    void setMovieEarnings(String movieName, double earnings);

    void setDistributor(String movieName, String distributorName);

    void displayMovieDetails();
}