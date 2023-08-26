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
* The API is divided into two classes: Service and Controller
  * The Service class contains the logic
  * The Controller class declares how and what will be executed under the specified URL


## **🛠️ How to test**
* Swagger - All endpoints easy to test without other tools 
end-point http://localhost:8080/swagger-ui/index.html#/git-hub-controller/getGitHubRepositories
![image](https://github.com/mat-rys/GitHub-Repository-Viewer/assets/98847639/7125f58b-78f5-4001-9450-afa7b6d6e543)

* Postman - An external tool where the user needs to input parameters according to the guidelines and send a GET request to the appropriate endpoint: http://localhost:8080/repo
![image](https://github.com/mat-rys/GitHub-Repository-Viewer/assets/98847639/748431fb-dca8-4f36-9f4f-bf0ea9f16068)

* Just pasting with params in url into website
Don't forget about filling username and type
example: http://localhost:8080/repo?username={YOUR USERNAME}&Accept:={ TYPE}
