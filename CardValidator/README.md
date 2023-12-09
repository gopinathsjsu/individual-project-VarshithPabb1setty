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
cd CardValidator

Then install maven
mvn install

Compile the project using maven
mvn compile

Then we can manually test for all the file types:

JSON command:
mvn exec:java -Dexec.args="resources/input_file.json resources/output_file.json”

XML command:
mvn exec:java -Dexec.args="resources/input_file.xml resources/output_file.xml"

CSV command:
mvn exec:java -Dexec.args="resources/input_file.csv resources/output_file.csv”



## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
