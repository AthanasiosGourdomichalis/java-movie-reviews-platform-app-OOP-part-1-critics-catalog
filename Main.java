import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		Platform platform = new Platform();//Instance of the Platform class. Represents the platform managing the collection of movies within a list, alongside one active user session at a time
		Scanner in = new Scanner(System.in);

		//Instantiate Comparator objects of appropriate types based on the sorting criteria
		MovieAverageRatingComparator comp1 = new MovieAverageRatingComparator();
		MovieTitleComparator comp2 = new MovieTitleComparator();
		MovieYearComparator comp3 = new MovieYearComparator ();


//----------------------------------------------DEMO---------------------------------------------------------------------
		//Programmatically instantiate custom Movie objects with all properties fully populated
		Movie m1 = new Movie("Iron Man", 2008, List.of("Action", "Sci-Fi"), "Jon Favreau");
		Movie m2 = new Movie("The Dark Knight", 2008, List.of("Action", "Crime", "Drama"), "Christopher Nolan");
		Movie m3 = new Movie("Spider-Man", 2002, List.of("Action", "Adventure"), "Sam Raimi");
		Movie m4 = new Movie("Avengers: Endgame", 2019, List.of("Action", "Sci-Fi"), "Anthony Russo");
		Movie m5 = new Movie("Joker", 2019, List.of("Drama", "Thriller"), "Todd Phillips");
		Movie m6 = new Movie("Doctor Strange", 2016, List.of("Action", "Fantasy"), "Scott Derrickson");
		Movie m7 = new Movie("Man of Steel", 2013, List.of("Action", "Adventure", "Sci-Fi"), "Zack Snyder");
		Movie m8 = new Movie("Captain America: Civil War", 2016, List.of("Action", "Sci-Fi"), "Anthony Russo");
		Movie m9 = new Movie("Batman Begins", 2005, List.of("Action", "Adventure"), "Christopher Nolan");
		Movie m10 = new Movie("Black Panther", 2018, List.of("Action", "Adventure", "Sci-Fi"), "Ryan Coogler");

		//Add new movies to the platform's collection list
		platform.addMovie(m1);
		platform.addMovie(m2);
		platform.addMovie(m3);
		platform.addMovie(m4);
		platform.addMovie(m5);
		platform.addMovie(m6);
		platform.addMovie(m7);
		platform.addMovie(m8);
		platform.addMovie(m9);
		platform.addMovie(m10);

		//Programmatically instantiates custom User objects with fully populated properties
		User giannis = new User("giannis");
        User maria = new VerifiedUser("maria","maria@gmail.com");
        User kritikos = new Critic("kritikos","aueb@gmail.com","1234");
        User nikos = new User("nikos");
        User elena = new VerifiedUser("elena","elena@gmail.com");

        //Programmatically instantiates custom Review objects with fully populated properties
        Review r1 = new BasicReview(giannis, 8, "Very Good!", m1);
		giannis.addReview(r1); //Add a review to the user's list of reviews

        Review r2 = new BasicReview(maria, 9, "wow!", m1);
		maria.addReview(r2);

		//Adds a review to the corresponding movie's review list
		m1.addReview(r1);
		m1.addReview(r2);


        Review r3 =new CriticReview(kritikos, 10, "Just Perfect!", m2);
		kritikos.addReview(r3);

        Review r4 =new BasicReview(nikos, 7, "Good",m2);
		nikos.addReview(r4);

		m2.addReview(r3);
		m2.addReview(r4);

        Review r5 =new BasicReview(elena, 9, "Chaotic", m3);
		elena.addReview(r5);
		m3.addReview(r5);

        Review r6 =new CriticReview(kritikos, 8, "Good movie",m4);
		kritikos.addReview(r6);
		m4.addReview(r6);

        Review r7 =new BasicReview(giannis, 9, "", m5); //Objects created without an optional comment
		giannis.addReview(r7);
		m5.addReview(r7);

        Review r8 =new BasicReview(maria, 10, "", m6);
		maria.addReview(r8);

        Review r9 =new BasicReview(nikos, 9, "", m6);
		nikos.addReview(r9);

		m6.addReview(r8);
		m6.addReview(r9);

        Review r10 =new CriticReview(kritikos, 10, "The best movie of all time", m7);
		kritikos.addReview(r10);

		m7.addReview(r10);

	//----------------------------------------------------MENU-------------------------------------------------------------
		System.out.println("****************************************************************************************************");
		System.out.println("****************************************************************************************************");
		platform.login(); //  login MENU (Guest, Verified, Critic)

		//MAIN MENU
		while (true) {
			System.out.println("****************************************************************************************************");
			System.out.println("\n--- MENU ---");
			System.out.println("1. Add Movie"); //Movie registration
			System.out.println("2. Search Movie"); //Search
			System.out.println("3. List Sorted Movies (by Rating/Title/Year)"); //Sorting based on 3 criteria
			System.out.println("4. All Movies"); //Displays all movies in the catalog
			System.out.println("5. Show Profile"); //Prints user details
			System.out.println("6. Change User"); //Change active user account
			System.out.println("7. Exit"); //exit the app
			System.out.print("Choose (1-7): ");
			
			int input = Integer.parseInt(in.nextLine());
			System.out.println("----------------------------------------------------------------------------------------------------");
			if (input == 1) { //Movie registration
				platform.addMovie();
			}

			if (input == 2) { //Movie search (platform)
				if(platform.search()){
					System.out.println("----------------------------------------------------------------------------------------------------");
					System.out.print("Enter index of movie: ");
					int index = Integer.parseInt(in.nextLine());
					platform.specificMovie(index);
				}

			}

			if (input == 3) { //Sorting based on: 1.Rating\ 2.Title\ 3.Year of release
				System.out.println("1. Sort by Rating\n2. Sort by Title\n3. Sort by Year");
				
				System.out.print("Choose (1-3): ");
        
				String sortChoice = in.nextLine(); 
				System.out.println("----------------------------------------------------------------------------------------------------");
				List<Movie> templist = new ArrayList<Movie>();
				
				if (sortChoice.equals("1")) { //Displays top-rated movies per genre (with at least n reviews and average rating > x)

					System.out.println("Filter");
					System.out.print("Give number of reviews: ");
					int n = Integer.parseInt(in.nextLine());

					System.out.print("Give rating: ");
					double x = Double.parseDouble(in.nextLine());

					templist = platform.getSortedMovies(comp1);
					int i =0;
					for(Movie obj : templist){
						if(obj.getAverageRating()>x && obj.getNumberOfReviews()>n){ //(with at least n reviews and average rating > x)
							System.out.println(obj); 
							i++;
						}
						
					} if (i==0){
						System.out.println("No Movies Found");
					}

				}

				if (sortChoice.equals("2")) { //Sort alphabetically by Movie Title
					templist = platform.getSortedMovies(comp2);
					for(Movie obj : templist){
						System.out.println(obj);
					}

				}
				if (sortChoice.equals("3")) { //Sort by release year
					templist = platform.getSortedMovies(comp3);
					for(Movie obj : templist){
						System.out.println(obj);
					}

				}
				
			}
			if (input == 4) { //Displays details for all movies in the catalog list
				platform.listMovies();
			}
			if (input == 5) { //Prints user details
				platform.profile();
			}

			if (input == 6) { //Returns the user to the main menu to log in as a different account/user
				System.out.println("****************************************************************************************************");
				platform.login();
			}

			if (input == 7) { //exit
				System.out.println("Exiting...");
				System.out.println("****************************************************************************************************");
				System.out.println("****************************************************************************************************");
				break;
			}

			if( input>7 || input<1) { //else...
				System.out.println("Invalid choice.");
			}
		}


	}

}
