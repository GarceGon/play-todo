# Play-Todo

This is an example project made in Play of a one-page application task manager.
https://play-todo.herokuapp.com

## Backend
Developed with [Play framework](https://github.com/playframework/playframework), MySql and Ebean

To configure Database edit "/conf/application.conf":
```
...

db {
  # You can declare as many datasources as you want.
  # By convention, the default datasource is named `default`

  # https://www.playframework.com/documentation/latest/Developing-with-the-H2-Database
  # Default database configuration using MySQL database engine
  # Connect to playdb as playdbuser
  default.driver=com.mysql.jdbc.Driver
  default.url="jdbc:mysql://localhost:3306/play-task?autoReconnect=true&useSSL=false"
  default.username=root
  default.password="password"
  # You can turn on SQL logging for any datasource
  # https://www.playframework.com/documentation/latest/Highlights25#Logging-SQL-statements
  #default.logSql=true
}
```
## Frontend

Made with [Bootstrap](http://getbootstrap.com/) and [Vue.js](https://vuejs.org/)

All the changes in tasks are made through an API Rest defined in routes.
