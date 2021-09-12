# Enhance  API Test

1. As an API test: Retrieve a list of charities and confirm that St John is included in the list.
2. As an API test: Perform the same query and checks as the Web UI test  but use the
   API not the UI.

   Note: Then Second api test could not be completed. TradeMe sandbox website doesn't have any active used car listings and also it's not possible to create a new used car listing due to an error on the website
## How to run the test

Clone the repository
```xml
git clone -b main https://github.com/roshanRBA/TradeMeApiTest.git
```
Open the project
```xml
cd TradeMeApiTest
```
Run the test
```xml
mvn verify test
```
