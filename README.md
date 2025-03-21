# EvaPharmaTask

This project automates the user management functionality of the OrangeHRM application using **Selenium**, **Cucumber**, and **TestNG**. It includes test cases for adding, searching, and deleting users in the OrangeHRM admin panel.

---

## **Table of Contents**
1. [Project Overview](#project-overview)
2. [Technologies Used](#technologies-used)
3. [Prerequisites](#prerequisites)
4. [Setup Instructions](#setup-instructions)
5. [Running the Tests](#running-the-tests)
6. [Test Reports](#test-reports)
7. [Contributing](#contributing)
8. [License](#license)

---

## **Project Overview**
This project automates the following scenarios in the OrangeHRM application:
1. **Login** to the OrangeHRM application.
2. **Add a new user** with details like employee name, username, password, user role, and status.
3. **Search for the user** by username.
4. **Delete the user** and verify that the number of records decreases by 1.

The project follows the **Page Object Model (POM)** design pattern for better maintainability and reusability.

---

## **Technologies Used**
- **Selenium**: For browser automation.
- **Cucumber**: For behavior-driven development (BDD) and writing test cases in Gherkin syntax.
- **TestNG**: For test execution and reporting.
- **Maven**: For dependency management and project build.
- **Java**: As the programming language.
- **GitHub**: For version control and collaboration.

---

## **Prerequisites**
Before running the project, ensure you have the following installed:
1. **Java Development Kit (JDK)**: Version 11 or higher.
2. **Maven**: For dependency management.
3. **Chrome Browser**: The tests are configured to run on Chrome.
4. **ChromeDriver**: Ensure the ChromeDriver version matches your Chrome browser version.
5. **IDE**: IntelliJ IDEA or Eclipse for running the project.

---

## **Setup Instructions**
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/orangehrm-automation.git
   cd orangehrm-automation