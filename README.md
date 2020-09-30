# PROJECT

**Test task:**
Write an automated test to verify that the “Add a new computer” functionality in “Computer database” is working.

**Desirable:** filling in all the data in the form of adding a new computer. 
**Introduced date:** 10 years ago before the test was written.
**Discontinued:** date the test was written.
**[http://computer-database.gatling.io/computers](http://computer-database.gatling.io/computers)**

### Platforms

- Debian/Ubuntu
- Windows

### Install

Install and configure Apache Maven from the binaries provided by the Maven project.

* `git clone git@github.com:alex2018hillel/Project.git`

### Run test

* `mvn clean test` - run your tests

You can generate a report using one of the following command:

* `mvn allure:serve`

Report will be generated into temp folder. Web server with results will start.

* `mvn allure:report`

Report will be generated tо directory: `target/site/Project/index.html`

![Alt text](src/main/resources/allure.jpg?raw=true "Basic Features")
![Alt text](src/main/resources/allure.png?raw=true "Basic Features")
