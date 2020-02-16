# TkwAssigmentFunctionAutomatedTesting
 
Before run:
Install maven, java and set paths to maven_home and java_home along with "bin" paths to both of them in "PATH" (windows)
to run reports properly you need to install Allure, you can install it from from the Scoop commandline-installer by running command in powershell 'scoop install allure'
You can also run allure manually: 
-Download the latest version as zip archive from Maven Central.
-Unpack the archive to allure-commandline directory.
-Navigate to bin directory.
-Use allure.bat for Windows or allure for other Unix platforms.
-Add allure to system PATH.
Running scripts:
run test from cmd using command "mvn test "-Dtest.headless=false" " or mvn test "-Dtest.headless=true" to run in headless mode
Additional info:
data file is called adressTestData.json and is located in main catalog 
Report should open after test run finished, if there's problem make sure that allure-result catalog has been created in the main project's folder
if folder has been created somewhere else you can change the deployment path in method allureReport located in BasePage to the correct path(path to allure-result folder).
  
