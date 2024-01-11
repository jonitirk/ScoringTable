The app can be found at https://scoringtable-4eec9f6d9315.herokuapp.com/ 

## Application description:

This is a simple fantasy sports app where you can enter a player's first name, last name, goals, assists, and team. Points are calculated by combining goals and assists, and players are displayed in the app in order of who has the most points. Admin users can edit player information and perform CRUD operations, including adding or removing players. In this version, it's also possible to input an anonymous player. Teams have their own page where admin users can add teams. Editing or deleting teams is not possible in this version.

## Technical specifications:

It's a Spring Boot Maven project using the MVC architecture. Views are created using Thymeleaf templates with some CSS for UI styling.

The application's database is the H2 test database. JPA is used to create database functionalities. Test data are preloaded into the application and logged.

The application includes a RestController.java, enabling the use of RESTful methods for some functionalities (not all functionalities are implemented with REST methods). Auto-generated Spring DATA REST URLs are available at the /api endpoint.

The application includes the Spring Security dependency, securing specific URLs and methods so that only users with the admin role can access them. User passwords are encrypted. For testing purposes, the H2 console is not secured.

There are also a few JUnit test methods in the application.

This application has been published on GitHub to give employers an insight into my programming skills. For this reason, the repository is public, and for testing purposes, the application's usernames and passwords are the following:

Username: User, Password: User 

Username: Admin, Password: Admin

Screenshots of the application:

![sign_in](https://github.com/jonitirk/ScoringTable/assets/89454122/947311de-94a3-4c0f-ba00-e0d86c53fda5)

![user_players](https://github.com/jonitirk/ScoringTable/assets/89454122/cf31a67b-6b5e-46d6-a475-54d6f74024ac)

![user_teams](https://github.com/jonitirk/ScoringTable/assets/89454122/788173ab-7223-41d6-a250-ce8529ed711a)


![admin_players](https://github.com/jonitirk/ScoringTable/assets/89454122/3631476b-f9e0-4a09-b9db-42196659cf3c)

![add_player](https://github.com/jonitirk/ScoringTable/assets/89454122/16d2c103-537a-4c3d-a7c4-6f78c448b1c8)

![modify_player](https://github.com/jonitirk/ScoringTable/assets/89454122/8d8638d7-8948-4bcf-8784-70e98e2d5641)

![add_team](https://github.com/jonitirk/ScoringTable/assets/89454122/c9f7a3cb-058f-4680-8178-2f7a19c365b5)






