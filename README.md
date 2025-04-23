# TZ report-portal
### Общее:
Проект предназначен для автоматизации тестирования интерфейса (UI) и программного интерфейса (API) Report Portal.
***

### Использованные технологии:
Сборка на Maven

UI тесты: Selenium, TestNG.
 
API тесты: Rest Assured.
***
### Описание методов классов:

 ##### UI
###### BasePage:
* getWait10() - метод для ожидания элементов в течение 10 секунд
		
###### DashboardsPage: 
* addNewDashboard(String name, String description) - добавляет новый Dashboard

* addNewWidget(String nameFilter, String nameLaunchFilter) - добавляет новый виджет

* getNameWidget() - возвращает имя добавленного виджета


 ##### API
 ###### BaseApiTest:
 * sendPostRequest(String body) - отправляет POST запрос
 * sendGetRequest(Integer id) - отправляет GET запрос

 
###### NegativeDashboardTests
* negativeTest() - проверяет запрос с длинным именим
	
###### PositiveDashboardTests
* successPostTest() - создаёт новый Dashboard через API

* verifyDashboardTest() - проверяет корректность данных созданного Dashboard
***		
### Примечание:
Убедитесь что Firefox установлен.

Введите рабочий токен в поле ACCESS_TOKEN в классе BaseApiTest.
***
### Команды:
* mvn clean test - чтобы сгенерировать тест
 
В консоли перейдите в папку проекта и выполните команду
* allure serve target/surefire-reports/ - Allure отобразит отчет, откроется окно браузера с отчетом
