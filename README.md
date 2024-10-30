## Project: Automated UI Tests for Stellar Burgers Website
URL: https://stellarburgers.nomoreparties.site/

### Technology Stack
- Java
- JUnit
- Selenium WebDriver
- Rest-Assured (for auxiliary actions via API)
- Maven
- Allure
- Java Faker, RandomStringUtils
- Java Properties (for easy browser switching)
- WebDriverManager (for driver management automation)
- POM (Page Object Model)
- Parametrization 
- Lombok
- POJO

### Main Test Cases

- Registration and Authorization 
- Buttons' clickability
- Transitions between pages
- Exit

### Installation and Execution
#### Install
1. Clone the repository:  
   *git clone https://github.com/artyomkravts/FinalProject3-UI.git*
2. Navigate to the project folder:  
   *cd <project folder name>*
#### Firefox
1) In *config.properties*, set *browser=firefox*
2) mvn clean test
#### Chrome
1) In *config.properties*, set *browser=chrome*
2) mvn clean test
#### Yandex
1) In *config.properties*, set:
- *browser=yandex* 
- *driver.version=*  
*взять версию яндекса, набрав в поиске browser://version/,  
  Find your Yandex version by searching browser://version/. Based on this version number, find the matching Chrome version here: https://googlechromelabs.github.io/chrome-for-testing/known-good-versions.json*
- *webdriver.yandex.exe.path= <path to the Yandex .exe file>*
2) mvn clean test