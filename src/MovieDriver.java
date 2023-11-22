import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieDriver {
    public static void main(String[] args) {
        // Initialize lists for movies and distributors
        List<Movie> movies = new ArrayList<>();
        List<Distributor> distributors = new ArrayList<>();

        // Create instances of managers
        MovieManagement movieManager = new MovieManager(movies, distributors);
        DistributorManagement distributorManager = new DistributorManager(distributors);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu Options:");
            System.out.println("1. Add Movie");
            System.out.println("2. Remove Movie");
            System.out.println("3. Set Movie Earnings");
            System.out.println("4. Set Distributor");
            System.out.println("5. Distributor Movie Details");
            System.out.println("6. Display Movie Details");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addMovie(scanner, movieManager);
                    break;
                case 2:
                    removeMovie(scanner, movieManager);
                    break;
                case 3:
                    setMovieEarnings(scanner, movieManager);
                    break;
                case 4:
                    setDistributor(scanner, movieManager);
                    break;
                case 5:
                    distributorMovieDetails(scanner, distributorManager);
                    break;
                case 6:
                    movieManager.displayMovieDetails();
                    break;
                case 7:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addMovie(Scanner scanner, MovieManagement movieManager) {
        System.out.print("Enter movie name: ");
        String name = scanner.nextLine();

        System.out.print("Enter director's name: ");
        String director = scanner.nextLine();

        movieManager.addMovie(name, director);
        System.out.println("Movie added successfully.");
    }

    private static void removeMovie(Scanner scanner, MovieManagement movieManager) {
        System.out.print("Enter the name of the movie to remove: ");
        String movieName = scanner.nextLine();

        movieManager.removeMovie(movieName);
        System.out.println("Movie removed successfully.");
    }

    private static void setMovieEarnings(Scanner scanner, MovieManagement movieManager) {
        System.out.print("Enter the name of the movie: ");
        String movieName = scanner.nextLine();

        System.out.print("Enter earnings for the movie: ");
        double earnings = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        movieManager.setMovieEarnings(movieName, earnings);
        System.out.println("Earnings set successfully.");
    }

    private static void setDistributor(Scanner scanner, MovieManagement movieManager) {
        System.out.print("Enter the name of the movie: ");
        String movieName = scanner.nextLine();

        System.out.print("Enter distributor name: ");
        String distributorName = scanner.nextLine();

        movieManager.setDistributor(movieName, distributorName);
        System.out.println("Distributor set successfully.");
    }

    private static void distributorMovieDetails(Scanner scanner, DistributorManagement distributorManager) {
        System.out.print("Enter the name of the distributor: ");
        String distributorName = scanner.nextLine();

        System.out.print("Enter the name of the movie: ");
        String movieName = scanner.nextLine();

        distributorManager.distributorMovieDetails(distributorName, movieName);
    }
}