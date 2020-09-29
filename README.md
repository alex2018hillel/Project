# PROJECT

Test task:
Write an automated test to verify that the “Add a new computer” functionality in “Computer database” is working.
[http://computer-database.gatling.io/computers](http://computer-database.gatling.io/computers)
Desirable: filling in all the data in the form of adding a new computer. 
Introduced date: 10 years ago before the test was written
Discontinued: date the test was written

Install and configure Apache Maven from the binaries provided by the Maven project.

### Platforms

- Debian/Ubuntu
- Windows

### Run test

* `mvn clean test` - run your tests

You can generate a report using one of the following command:

* `mvn allure:serve`

Report will be generated into temp folder. Web server with results will start.

* `mvn allure:report`

Report will be generated tо directory: `target/site/allure-maven/index.html`


**Author:** Seth Chisamore ([schisamo@chef.io](mailto:schisamo@chef.io))

**Author:** Bryan W. Berry ([bryan.berry@gmail.com](mailto:bryan.berry@gmail.com))

**Author:** Leif Madsen ([lmadsen@thinkingphones.com](mailto:lmadsen@thinkingphones.com))

**Copyright:** 2008-2017, Chef Software, Inc.
