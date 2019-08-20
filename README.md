2019-08-20

First run DBInit, then AkkaBootApp
You can run from IntelliJ or with command 'sbt run'

Check if port 9090 is open
You can change port in resources/application.config
(Double shift for search file in IntelliJ)

You can get data from database writing 'http://localhost:9090/api/v1/books' in your browser
Or by Postman / curl
For more endpoints check BookRoutes

Scala version: 2.12.6
Sbt version: 1.2.8
All used libraries/frameworks in build.sbt