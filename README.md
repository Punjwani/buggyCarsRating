Application:

https://buggy.justtestit.org

------------------------------------

Pre-requisites:

openjdk version "1.8.0_292"

Apache Maven 3.6.3 

IDE IntelliJ 

cucumber-java 6.10.4 

cucumber-junit 6.10.4 

selenium-java 4.1.0 

junit version 4.13

------------------------------------
Drivers:

src/test/resources/Drivers

Implemented for Linux but has a Windows driver saved as well.
To run on windows -> Uncomment the path for Windows from: src/test/java/StepDefinitions/base.java (line 22)

------------------------------------

Run:
src/test/java/StepDefinitions/testRunner.java

Run from testRunner, includes all the tagged tests:
src/test/java/StepDefinitions/testRunner.java

------------------------------------

Reports:
target/Reports

3 types of reporting implemented:
HTML - target/Reports/HtmlReports
JSON - target/Reports/JsonReports
JUNIT - target/Reports/JunitReports