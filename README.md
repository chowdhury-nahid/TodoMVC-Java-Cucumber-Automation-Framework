
# todomvc_automation

Basic usage automation of a todo application using Java Cucumber.

application URL:
http://todomvc.com/examples/vue/

Language: Java 

Framework: Cucumber 

Driver: Selenium Webdriver

## Project Set-up

Clone this repository to your project directory.

```bash
  git clone https://github.com/chowdhury-nahid/todomvc_automation.git
```
    
## Running Tests

### Requirements
To run tests, 
1. Download the latest chrome driver that matches your chrome from this url- https://chromedriver.chromium.org/downloads

Extract the `chromdriver.exe` file to `src/test/resources/drivers` location of the project.

2. Open the maven `pom.xml` file and update the dependencies.
3. Run the `src/test/java/stepDefinitions/TestRunner.java` file

### Reports

The reports of the test run will be stored in `target/cucumber-reports` folder.



