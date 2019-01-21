## For UI testing

## Project components used - Java, Maven, Testng, log4j

## How to use execute this project - execute by importing it in IDE or execute it from CMD
# IDE -
1. Follow all the steps as mentioned in Reference - https://www.360logica.com/blog/how-to-import-a-java-project-into-eclipse-ide/
# CMD -
per-req:
You should have java and maven installed in yr machine, check by executing below command in cmd
java -version
mvn - version
Steps to follow:
1. Go to the project directory, where you testng.xml is present and to execute write below command in cmd - 
mvn test
2. This command will execute all the test classes mentioned in the testng.xml
3. For any problem faced, try to clean maven - mvn clean install. It should solve the maximum issue.

## Execution results
#Index.html
1. Navigate to your project directory XX/qa-test-hf/test-output/index.html and open the html page
#emailable-report
1. Navigate to your project directory XX/qa-test-hf/test-output/emailable-report.html and open the html page

## logging framework - log4j used

## Configurable properties files - location XX/qa-test-hf/config.properties
1. It has components for driver to use during UI test cases, url and screenshot folder.

## Browser option (Browser factory)- Chrome and Firefox
1. It can be configured from config.properties before tests.

## Parallel mode of TestNG
1. You can configure the execution of parallel mode by configuring thread-count in testng.xml
2. Default value: thread-count="1"
3. Please do cosider perfomance of web site before configuring this value.

##Listeners used - ITestListener & ITestResult
1. Its configurable from location - XX\qa-test-hf\src\test\java\com\hellofresh\tests\WebTest.java
2. By Default - ITestListener

##Libraries
1. All libraries used are configured in pom.xml with description why they are being used.



- 