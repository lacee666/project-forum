# Projekt eszközök
## Team
- Bulatovic László
- Vass Zsigmond Ádám
- Velkei Bence
- Veress Marcell

# project-forum documentation

## How to build and run:
- Download and install the followings:
     - Node 8.X.X version
     - Angular4 (commandline install: npm install -g @angular/cli)
     - You'll require atleast java version 1.8
     - The newest version of git.
     - Download maven and put it into PATH variable
- Clone project from the repository:
     - git clone https://github.com/lacee666/project-forum.git
- Deploy:
     - frontend: Run the command "npm start" at project-forum/frontend/forum (it will run on port 4200)
     - backend: Run the command "mvn spring-boot:run" at project-forum/backend/forum (it will run on port 8080)
     - Open the webpage in a browser at: localhost:4200

## Functional requirements:
Project-forum is a website for all kinds of good purpose forumtypes. We do not condone any hate, crime or or malicious activities. The forum provides a good place to share your thoughts with anyone around the world. All guests can register on the website and become users who can then create subforums, forumposts and comments.

## Non-Functional requirements:
The website has to be secure, no information can be given out to third parties and cannot sell any user data. The website protects the users data and only the user can access it. The forum also has to be accessible all around the world and users who have some kind of disabilities should read the website with ease. 
Use Case diagram:
![usecase](task/usecase.png)
### Roles:
     - Guest: guests can register, login and access the forums, forumposts and comments.
     - User: users can logout, create forum where they can delete comments, delete forumposts, ban users and delete the forum. They can  access the forumpages too and create forumposts, comments, upvote and downvote. They can also have favorites and can see their  upvotes and downvotes.

## Endpoints
- GET Index page: /index or /
- GET Profile page: /profile
- GET User page: /user/{id}
- GET Forum page: /forum/{forumName}
- GET Forumpost page: /forum/{forumName}/{id}
- POST registration: /registration
- GET login: /login
- Get all forums: /all

### Backend
- Registration: /registration
Tables:
![database-tables](task/database-tables.JPG)
## Directory structure:
![dir-backend](task/dir-backend.JPG)
![dir-frontend](task/dir-frontend.JPG)

## Extra tools used for build
1. SonarQube:
- Setup:
     - Download the newest (non-beta) version of SonarQube and include it in the system variables path: {sonarqupe-dir}/sonarqube-{version}/bin/{os-version}
     - At the last line of "{sonarqube-dir}/conf/sonar.properties" insert the following:
          sonar.projetKey = forum
          sonar.projectName = forum
          sonar.projectVersion = 1.0
          sonar.sources = ForumApplication.java file directory (.../forum/src/main/java/com/forum/forum)
     - Run SonarQube at bin/{os-version}/StartSonar.bat (it will be running on port 9000)
     - Run the command "mvn sonar:sonar" at backend/forum directory
     - Open localhost:9090 in a browser and use can now use it.
2. google-java-formatter
- Setup   
     - In IntelliJ do the following: File -> Setting -> Plugin -> Browse repositories. Search for google-java formatter and install it. Restart the IDE and now you can reformat code by pressing CTRL+ALT+L

