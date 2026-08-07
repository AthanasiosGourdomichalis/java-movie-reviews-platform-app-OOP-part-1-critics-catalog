import java.util.*;

public class Platform{
    private List<Movie> Movies; //List of pre-made Movies in Main and input Movies made by Users  
    private User u; //User currently using the App

    public Platform() {
        this.Movies = new ArrayList<Movie>(); //List initialization
    } //Constructor

    Scanner in = new Scanner(System.in);

    //adds a Pre-made Movie in the Platfrom's List made in Main
    public void addMovie(Movie m){
        
        Movies.add(m);
    }
    //addMovie() method: Adds the user's movie to the platform's movie list
    public void addMovie(){

        System.out.print("Title: ");
        String title = in.nextLine();

        System.out.print("Year: ");
        int year = Integer.parseInt(in.nextLine());

        System.out.print("Director: ");
        String director = in.nextLine();

        List<String> genres = new ArrayList<>();
        for(;;){
            System.out.print("Add Genres or leave blank to end: ");
            String g = in.nextLine();
            if(!g.isEmpty()){
                genres.add(g);
            }else{
                break;
            }
        }
        boolean flag = false;
        for (Movie m : Movies) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Movie already exists.");
                flag = true;
            }
        }
        if (!flag) {Movie newMovie = new Movie(title, year,genres, director);
            Movies.add(newMovie);
            System.out.println("Movie added successfully.");
        }


    }



//------------------------------------------------------------------------------------------------------------
    public void login(){ //login() method makes a User instance in the LOGIN MENU, according to the user's choice
        boolean successful = false; //Boolean flag used to break the while loop
        while(!successful) {
            System.out.println("--- LOGIN ---\n1.Guest\n2.Verified User\n3.Critic"); //USER LOGIN MENU options 
            System.out.print("Choose (1-3): ");
            int choice = Integer.parseInt(in.nextLine());

            System.out.println("----------------------------------------------------------------------------------------------------");
            if (choice == 1) { //1. BASIC GUEST USER - ONLY HAS USERNAME
                System.out.print("Username: ");
                String name = in.nextLine();
                u = new User(name);
                successful = true; //Breaks the while loop once the User object is created with user input data
            } else if (choice == 2) {//2. VERIFIED USER HAS EMAIL TO LOGIN HIS USER ACCOUNT AND USERNAME
                System.out.print("Username: ");
                String name = in.nextLine();
                System.out.print("Email: ");
                String mail = in.nextLine();
                u = new VerifiedUser(name, mail);
                successful = true;//Breaks the while loop once the User object is created with user input data
            } else if (choice == 3) { //3. A CRITIC USER HAS AN EMAIL TO LOG INTO THEIR ACCOUNT AND A UNIQUE CODE TO DISTINGUISH IT AS A PROFESSIONAL ACCOUNT
                System.out.print("Username: ");
                String name = in.nextLine();
                System.out.print("Email: ");
                String mail = in.nextLine();
                System.out.print("Code: ");
                String code = in.nextLine();
                u = new Critic(name, mail, code);
                successful = true;//BREAKS WHILE LOOP ONCE USER OBJECT IS CREATED WITH USER INPUT DATA
            }
        }
    }


//------------------------------------------------------------------------------------------------------------    
    public boolean search() {//SEARCH MOVIE, MAIN MENU OPTION. BOOLEAN METHOD
        System.out.println("Searching...\nWith Movie Title (TYPE 1)\nWith Director Name (TYPE 2)"); //OPTION 1: SEARCH BY TITLE, OPTION 2: SEARCH BY DIRECTOR NAME
        
		System.out.print("Choose (1-2): ");
        int ans = Integer.parseInt(in.nextLine());
        boolean found = false; //BOOLEAN FLAG SET TO FALSE IF MOVIE IS NOT FOUND
        if (ans == 1) {
            System.out.print("Give Movie Title:  ");
            String name = in.nextLine();
            System.out.println("Results for: " + name);
            for (Movie obj : Movies) {
                if (obj.getTitle().toLowerCase().contains(name.toLowerCase())) { //THE TITLE CONTAINS THE USER INPUT STRING
                    System.out.println("(Index: " + Movies.indexOf(obj) + ") " + obj); //movie display
                    found = true;//MOVIE FOUND
                }
            }
        } else {
            System.out.print("Give Director Name:  ");
            String name = in.nextLine();
            System.out.println("Results for: " + name);
            for (Movie obj : Movies) {
                if (obj.getDirector().toLowerCase().contains(name.toLowerCase())) {//THE DIRECTOR NAME CONTAINS THE USER INPUT STRING
                    System.out.println("(Index: " + Movies.indexOf(obj) + ") " + obj); //movie display
                    found = true;// MOVIE FOUND
                }
            }
        }
        if(!found){
            System.out.println("No Movies Found"); //NOT FOUND
        }
        return found;//RETURN TRUE/FALSE WHETHER THE MOVIE WAS FOUND OR NOT
    }

//---------------------------------------------------------------------------------------------------------
    //specificMovie(int ...) method displays/adds reviews, displays related movies
    public void specificMovie(int index){ 

        Movies.get(index).printDetails(); //DISPLAY DETAILS OF THE MOVIE REQUESTED BY THE USER, BASED ON THE INDEX OF THE MOVIE LIST

        System.out.println("1.Movie Reviews\n2.Show Related Movies\n3.Exit"); 
        System.out.print("Choose (1-3): ");
        int ans = Integer.parseInt(in.nextLine());

        if(ans==1){ // OPTION 1: DISPLAY/ ADD REVIEWS
            Movies.get(index).printReviews();// DISPLAY REVIEWS
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.print("Add Review (YES/NO): ");
            String ans2 = in.nextLine();
            if(ans2.equalsIgnoreCase("yes")){
                addReview(index); //ADDS REVIEW, CALLS THE addReview METHOD, IMPLEMENTED BELOW:
            }
        }else if(ans==2){ //OPTION 2: DISPLAY RELATED MOVIES
            Movies.get(index).printRelatedMovies(Movies); //DISPLAY RELATED MOVIES, BASED ON THE PLATFORM'S MOVIE LIST
            System.out.println("----------------------------------------------------------------------------------------------------");
        }else{}//exit
    }


//-----------------------------------------------------------------------------------------------------------------
    //addReview(int ...) method ADDS A REVIEW TO THE MOVIE'S REVIEW LIST AND TO THE PLATFORM USER'S REVIEW LIST
    public void addReview(int index){
            System.out.print("Give Your Review (1-10): ");
            int rating = Integer.parseInt(in.nextLine());

            System.out.print("Add comment or leave blank: ");
            String com = in.nextLine();

            if(u instanceof Critic){//check if the user is a critic
                Review r = new CriticReview(u,rating, com, Movies.get(index));//creation of a professional review
                Movies.get(index).addReview(r);//addition to the movie of the movie list
                u.addReview(r);//addition to the user

            }else{
                Review r = new BasicReview(u, rating, com, Movies.get(index));//creation of a basic review
                Movies.get(index).addReview(r);//addition to the movie of the movie list
                u.addReview(r);//addition to the user
            }
    }



//---------------------------------------------------------------------------------------------------------
    public List<Movie> getSortedMovies(Comparator<Movie> comp) {
        List<Movie> sortedList = new ArrayList<>(Movies); // temporary list
        Collections.sort(sortedList, comp); // use of the sort(List, Comparator) method, to sort the movies in the list based on different comparators
        return sortedList;//returns the list sorted
    }

//-----------------------------------------------------------------------------------------------------------
    public void listMovies(){ //display of all the movies in the platform's list
        for(Movie obj : Movies){
            System.out.println(obj);
        }
    }
//-----------------------------------------------------------------------------------------------------------
    //profile() method calls the User's printDetails() method to print his profile's data
    public void profile(){
        u.printDetails();
    }


}