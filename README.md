# TodoMVC Java Cucumber Automation Framework

A comprehensive BDD testing framework for TodoMVC applications using Java, Cucumber, and Selenium.

## Overview

This repository contains a behavior-driven development (BDD) testing framework designed specifically for TodoMVC implementations. It leverages Cucumber for writing human-readable test scenarios and Java with Selenium for robust browser automation.

## Features

- BDD approach with Gherkin syntax for clear test specifications
- Complete test coverage for TodoMVC application specifications
- Cross-browser testing using Selenium WebDriver
- Page Object Model (POM) implementation for maintainable test code
- Cucumber reporting for detailed test results
- Maven integration for dependency management and build processes
- CI/CD pipeline integration examples

## Prerequisites

- Java JDK 11+
- Maven 3.6+
- Chrome, Firefox, or Edge browser

## Installation

```bash
# Clone the repository
git clone https://github.com/your-username/todomvc-java-cucumber-automation.git
cd todomvc-java-cucumber-automation

# Install dependencies
mvn clean install
```

## Running Tests

```bash
# Run all tests
mvn test

# Run with specific tags
mvn test -Dcucumber.filter.tags="@smoke"

# Run with specific browser
mvn test -Dbrowser=chrome
mvn test -Dbrowser=firefox
mvn test -Dbrowser=edge
```

## Project Structure

```
├── src/
│   ├── main/java/
│   │   ├── pages/           # Page Object Models
│   │   └── utils/           # Helper utilities
│   └── test/
│       ├── java/
│       │   ├── stepdefs/    # Step definitions
│       │   └── runners/     # Cucumber test runners
│       └── resources/
│           ├── features/    # Cucumber feature files
│           └── config/      # Test configuration
├── target/
│   └── cucumber-reports/    # Test reports output
└── pom.xml                  # Maven configuration
```

## Test Coverage

- Todo creation
- Todo editing
- Todo completion
- Todo deletion
- Todo filtering (All, Active, Completed)
- Mark all as complete
- Clear completed todos
- Persistence verification
- Edge cases handling

## Feature File Example

```gherkin
Feature: TodoMVC Basic Functionality

  Scenario: Add new todo item
    Given I am on the TodoMVC application
    When I add a new todo item "Buy groceries"
    Then I should see the item "Buy groceries" in the todo list
    
  Scenario: Complete todo item
    Given I am on the TodoMVC application
    And I have added a todo item "Buy groceries"
    When I mark the item "Buy groceries" as completed
    Then The item "Buy groceries" should be displayed as completed
```

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- [TodoMVC](https://todomvc.com/) for providing the application to test
- [Cucumber](https://cucumber.io/) for the BDD framework
- [Selenium WebDriver](https://www.selenium.dev/) for browser automation
