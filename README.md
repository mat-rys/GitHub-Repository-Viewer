# GitHub-Repository-Viewer

## **🚀 The project idea:**
The project's idea is to provide a username and a chosen display format (which is enforced as JSON), then search for repositories that are not forks and display their names, Owner Login, and, for each branch, its name and last commit SHA.

## **💻 Technologies:**
* ![Java](https://img.shields.io/badge/-Java-007396?style=flat-square&logo=java&logoColor=white)
* ![Spring](https://img.shields.io/badge/-Spring-6DB33F?style=flat-square&logo=spring&logoColor=white)
* ![InteliJ](https://img.shields.io/badge/-IntelliJ%20IDEA-000000?style=flat-square&logo=intellij-idea&logoColor=white)
* ![Maven](https://img.shields.io/badge/-Maven-C71A36?style=flat-square&logo=apache-maven&logoColor=white)
* ![Lombok](https://img.shields.io/badge/-Lombok-BC6F09?style=flat-square&logo=lombok&logoColor=white)
* ![Swagger](https://img.shields.io/badge/-Swagger-85EA2D?style=flat-square&logo=swagger&logoColor=black)

## **📚 Code description**
* The API is divided into two classes:
  * The Service class contains the logic
  * The Controller class declares how and what will be executed under the specified URL

* How it works:
The controller handles incoming requests, accepting a username and enforcing JSON format as input. It then delegates the request to the service, which interacts with the GitHub API to retrieve repositories associated with the provided username. The service extracts repository information, including names and owner logins, and fetches branch data for each repository, including branch names and last commit SHAs. The collected data is then formatted and returned in a structured response, allowing users to easily view relevant repository details and branch information.

## **🛠️ How to test**
* first way Swagger - All endpoints easy to test without other tools 
end-point http://localhost:8080/swagger-ui/index.html#/git-hub-controller/getGitHubRepositories
![image](https://github.com/mat-rys/GitHub-Repository-Viewer/assets/98847639/7125f58b-78f5-4001-9450-afa7b6d6e543)

* second way Postman - An external tool where the user needs to input parameters according to the guidelines and send a GET request to the appropriate endpoint: http://localhost:8080/repo
![image](https://github.com/mat-rys/GitHub-Repository-Viewer/assets/98847639/748431fb-dca8-4f36-9f4f-bf0ea9f16068)

* third way Just pasting with params in url into website
Don't forget about filling username and type
example: http://localhost:8080/repo?username={YOUR_USERNAME}&Accept:={TYPE}

## **☕ Documents that helped to understand the construction of the project**
* GitHub docs with description of the endpiont that I used: https://docs.github.com/en/free-pro-team@latest/rest/repos/repos?apiVersion=2022-11-28#list-repositories-for-a-user
* GitHub docs with documentation of the search connection limits with endpiont: https://docs.github.com/en/rest/rate-limit/rate-limit?apiVersion=2022-11-28
