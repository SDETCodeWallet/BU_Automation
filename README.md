# Test Automation
This is a project based on Testng, Maven, Java, Selenium, Rest Assured, Chrome and Firefox to automate web application and back-end Restful API's. 

The project's source code is located (https://github.com/TestingGroup360/Automation.git)

## Build
### Requirements

The following applications need to be installed in order to build:

* Java 8 JDK
* Apache Maven 
* Chrome Driver [optional]
* Firefox Driver [optional]

The project leverages maven profiles and resource, Selenium web drivers and Rest assured.

##Configuration: 

To configure the Web application and Rest API used Config.properties file under "/com.automation.project/config.properties"; 

##Selenium WebDriver: 

To automate web applications we used selenium webdriver using Java, Maven and TestNG framework.

##Design pattern: 
Page object model is used to design the web application pages.  "com.automation.project/src/main/java/com/automation/application/pages"

#Global Constants: 
Application constants declare under /com.automation.project/src/main/java/com/automation/constants/utils ,Http Method type and browser type configuration and Status codes, Folder and files. 

##Interfaces: 
Two interfaces declare to define generic functions for web and IAPI. which is further implemneted under driver and API driver classes resp.
Under "/com.automation.project/src/main/java/com/automation/interfaces"

##Rest Assured: 
To automate the Restful API's, Framework leverages Rest assured library with Java. 


## Reports
Extent reports used for reporting to mention all the steps in HTML fromat.On completion of Test execution, ExtentReportResults.html will automatically generate under "/com.automation.project/ExtentReportResults.html"; 
Extent Report configuration done: /com.automation.project/src/main/java/com/automation/reports

Extent Reports: /com.automation.project/ExtentReportResults.html
TestNG Reports: com.automation.project/test-output/emailable-report.html

Web Application UML Diagram:/com.automation.project/WebUMLDiagram.png
API UML Diagram: /com.automation.project/APIUMLDiagram.png 


##Test Runner: 
Single test can be run from test class by right click and click run by TestNG. 
Test Suite run from Testng.xml run by right click and run as Testng. 
Test suite can be run and build from maven. By using maven install command. 







