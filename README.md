## запуск через Maven
### Firefox
1) В config.properties установить - browser=firefox
2) mvn clean test
### Chrome
1) В config.properties установить - browser=chrome
2) mvn clean test
### Yandex (прости, Господи)
1) В config.properties установить:
- browser=yandex 
- driver.version=  
*взять версию яндекса, набрав в поиске browser://version/,  
затем по номеру версии (кроме цифр последней точки) взять версию chrome отсюда: https://googlechromelabs.github.io/chrome-for-testing/known-good-versions.json*
- webdriver.yandex.exe.path= *путь до .exe Яндекса*
2) mvn clean test