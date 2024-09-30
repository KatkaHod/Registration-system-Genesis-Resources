Project Overview: GenesisResources Registration System


This Spring Boot application provides a RESTful API for managing user registrations within the GenesisResources system. The application allows for the creation, retrieval, updating, and deletion of user records in a MySQL database.

Key Features
User Creation: The API allows for the creation of new user records. Each user is assigned a unique UUID, generated using the UuidGenerator service.
User Retrieval: The application supports fetching a single user by ID as well as retrieving a list of all users.
User Update: Existing user records can be updated with new values for Name and Surname.
User Deletion: Users can be deleted by specifying their unique ID. The API handles cases where the user is not found, returning appropriate HTTP status codes.

Technologies Used
Spring Boot: Framework for building the RESTful web services.
JDBC Template: Used for interacting with the MySQL database.
MySQL: Relational database for storing user data.
Mockito: For unit testing repository methods.
RESTful API: The application provides a RESTful interface for managing user data, following standard HTTP methods.

Endpoints
POST /api/v1/user: Creates a new user.
GET /api/v1/user/{id}: Retrieves a user by their ID.
GET /api/v1/users: Retrieves all users.
PUT /api/v1/user: Updates an existing user's details.
DELETE /api/v1/user/{ID}: Deletes a user by their ID.

Error Handling:
The application handles common errors such as missing user IDs, not found users, and general server errors, returning appropriate HTTP status codes and messages.

How to Run:
To run this application, clone the repository and import it into your preferred Java IDE (e.g., IntelliJ). Make sure you have a MySQL database set up with the correct credentials configured in application.properties. Then, run the application as a Spring Boot application.
