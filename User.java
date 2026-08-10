import java.util.*;
public class User implements Printable { //The User class implements the Printable interface: represents a standard user of the company's web application without a linked account
	protected String username;
	protected List<Review> reviews;

	public User(String username) {
		this.username = username;
		this.reviews = new ArrayList<Review>(); //Creates a list of the user's reviews
	}  //constructor of User Class

	public void addReview(Review r) {
		reviews.add(r);
	} //Adds the User's review to their list


	public String getUsername() {
		return username;
	} //User class getter: returns the username


	public void printDetails() {
		System.out.println("[Guest] User: " + username);
		System.out.println("Reviews submitted: " + reviews.size());
	} //Displays the username and total number of reviews submitted
}


