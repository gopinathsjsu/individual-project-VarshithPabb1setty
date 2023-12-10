## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

All files are in *src/main/java* path.

Main method is in *CreditCardProcessor.java*

## Commands to execute the project

Make sure you are in CardValidator
> cd CardValidator

Then install maven
> mvn install

Compile the project using maven
> mvn compile

Then we can manually test for all the file types:

JSON command:
> mvn exec:java -Dexec.args="resources/input_file.json resources/output_file.json”

XML command:
> mvn exec:java -Dexec.args="resources/input_file.xml resources/output_file.xml"

CSV command:
> mvn exec:java -Dexec.args="resources/input_file.csv resources/output_file.csv”


## Primary Problem
The primary problem your project solves is parsing and processing credit card records from different file formats (CSV, JSON, XML). Each record includes a credit card number, expiration date, and cardholder's name. The main challenge is to read these records, validate the credit card number, determine the card issuer, and create an instance of the appropriate credit card class.

## Secondary Problems
**File Format Flexibility:** The system needs to handle various input file formats (CSV, JSON, XML) and potentially accommodate new formats in the future.

**Credit Card Validation:** Each credit card number must be validated to check if it's a legitimate number and identify the card issuer (Visa, MasterCard, AmericanExpress, Discover).

## Design Patterns Used
**Factory Pattern:**
Used in CreditCardFactory to create instances of different credit card types based on the card number.
This pattern allows easy extension to support new credit card types in the future.

**Strategy Pattern:**
Implemented through the FileParser interface with different strategies for parsing files (CSVParser, JSONParser, etc.).
This pattern provides flexibility to add new file parsing strategies without modifying the existing code.

**Utility Class:**
CardValidationUtil for shared validation logic, enhancing code reuse and separation of concerns.



**UML Class Diagram for Factory Pattern Implementation:**

![UML Class Diagram for Factory Pattern](https://github.com/gopinathsjsu/individual-project-VarshithPabb1setty/assets/144189651/68a6c65a-8c35-4d67-87e6-5624d8e9f52f)

**UML Class Diagram for Strategy Pattern Implementation:**
![UML Class Diagram for Strategy Pattern](https://github.com/gopinathsjsu/individual-project-VarshithPabb1setty/assets/144189651/57f90815-46b2-4b52-8d9d-941302203dc0)

## Consequences of Using These Patterns
**Factory Pattern:**

**Pros:** Simplifies the creation of credit card objects, centralizes the creation logic, and makes the system more maintainable and extensible.

**Cons:** The factory class can become a single point of failure and may need modification when adding new subclasses.

**Strategy Pattern:**

**Pros:** Enhances the flexibility and scalability of the file parsing process. New parsing strategies can be added without altering existing code, adhering to the Open/Closed Principle.

**Cons:** Can introduce additional complexity with multiple strategy classes. Requires proper handling of the context where strategies are switched.


## Note: **All the Documentation and other UML Diagrams are in the folder CardValidator/Documentatio & Diagrams.**


## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
