# **Movie platform application** `[Computer Programming with Java Assignment]` [`Part 1`]
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
---
> ## `Assignment purpose`:
> This **assignment** aims to develop an `object-oriented system` for **representing**, **organizing**, and **performing basic processing on information** related to ***movies*** and their ***reviews***. We are required to **design** and **implement** `class hierarchies`, utilize `core Java Collection frameworks`, and develop `searching`, `filtering`, and `ranking capabilities`.
---
> ## `Context`:
> An **online movie platform** wants to organize its **movie catalog** to better understand **user preferences** and **improve the search** and **recommendation experience**. Users can **submit ratings** and **short reviews** for **movies they have watched**. To support the above, the company requires the development of an `object-oriented` model that represents the **core entities** (`movies`, `users`, `reviews`), **enables their insertion and retrieval**, and provides `searching`, `filtering`, and `ranking functionality`. 
---
> ## `Description`
> The system will represent information related to `movies`, `user reviews`, and `ratings`, to address *queries* such as:
>  * Which are the top movies by genre?
>  * What is the average rating of a movie?
>  * Which movies are linked to a specific movie based on genre?
>  * Which users have rated specific movies?

> The data will be inserted programmatically (hardcoded), without using external files. 
---
## 📄 Documentation
* For a **detailed description** of the **assignment requirements**, **assignment purpose**, **context**, **description**, **design requirements**, **indicative functionalities**, **mandatory requirements**, **assignment instructions**, etc. please refer to the **assignment document**: [assignment.pdf](./assignment.pdf)
* For a detailed `user guide` of the application please refer to: [README.pdf](./README.pdf)
---
# User Guide:
## 1. SYSTEM DESIGN (class hierarchies)
<img width="1384" height="690" alt="image" src="https://github.com/user-attachments/assets/461027cf-ebbd-47ce-98d2-bf7809c87365" />

---
## 2. FUNCTIONALITY 
### 2.1 Core Features 

#### - User Management:

* Registration / Login for 3 user types (Guest, Verified, Critic) 
* Account switching 

#### - Movie Management: 
* Movie addition 
* Search by title or director 
* Sorting (by rating with a minimum of 𝑁 reviews and average rating > 𝑋, title, release year) 
* Movie recommendation / association (same genre, common director) 
* Display movie list - Review System: 
* Submission of reviews (rating + comment) 
* Display of reviews 
* Automatic average rating calculation
---
## 3. LOGIN 
### 3.1 Login System  
#### - Select Account Type: 
* Guest (Type 1): Username only (can submit basic reviews) 
* Verified User (Type 2): Username + email (can submit basic reviews) 
* Critic (Type 3): Username + email + password (can submit professional critic reviews)
---
## 4. MAIN MENU OPTIONS - DETAILED INSTRUCTIONS 
### 1. Add Movie 
#### - Available exclusively to Critic accounts 
#### - Steps: 
* a) Press '1' from the main menu.
* b) Enter the Movie Title when prompted. 
* c) Enter the Release Year (e.g., 2025). 
* d) Enter the director's full Name. 
* e) Add Genres one by one (press Enter after each genre). 
* f) When finished, press Enter on an empty line. 

The movie will be added to the platform if it does not already exist

---
## 2. Search Movie 
### - Steps:
    
* a) Press '2' from the main menu.
* b) Select the search type: 
  * Press '1' to search by Movie Title.
  *  Press '2' to search by Director Name. 
* c) Enter the search query (partial matches are supported). 
* d) View the list of results with index numbers. 
* e) For details: 
    * Enter the index number displayed before the title. 
    * Press Enter. 
* f) In the movie details view:

  * Press '1' to view reviews and write a new review.
  * Press '2' to view related movies. 
  * Press '3' to return to the main menu.

---
## 3. Sorted Movie List 
### - Steps: 

1. Press '3' from the main menu. 
2. Select sorting method:

- Press '1' to sort by Rating: 
  * Enter the minimum required number of reviews. 
  * Enter the minimum rating threshold (e.g., 7.5). 
  * Results are displayed with the highest ratings first. 
- Press '2' to sort by Title (A–Z). 
- Press '3' to sort by Year (newest first).
  
3. View the sorted list. 
4. Automatically returns to the menu after viewing.
---
## 4. All Movies
### - Steps:

* a) Press '4' from the main menu. 
* b) View the complete list of all movies. 
* c) The list is displayed and automatically returns to the menu.

---
## 5. View Profile 
### - Steps:

* a) Press '5' from the main menu.
* b) View your profile information: 
  - Username - Account type (Guest / Verified / Critic) 
  - All your submitted reviews 
  - For Critics: special Critic ID 
* c) Automatically returns to the menu after viewing.
---
## 6. Switch User 
### - Steps: 

* a) Press '6' from the main menu. 
* b) The login screen will appear again. 
* c) After successful login, return to the main menu.

---
## 7. Exit
### - Steps: 
* a) Press '7' from the main menu.
---
# 👤 Author
## **Athanasios Gourdomichalis** - [GitHub Profile](https://github.com/AthanasiosGourdomichalis)

---
