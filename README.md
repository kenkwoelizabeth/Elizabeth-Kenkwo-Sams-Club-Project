# Store ManagementApplication
 ![Langing Page](https://github.com/kenkwoelizabeth/Elizabeth-Kenkwo-Sams-Club-Project/assets/46757955/034260dd-3d08-4a1e-8b1e-68d3394382ea)
![Login Page](https://github.com/kenkwoelizabeth/Elizabeth-Kenkwo-Sams-Club-Project/assets/46757955/40892fc7-e666-4e82-b45b-0b2aeba2277b)
![Application Cover Page](https://github.com/kenkwoelizabeth/Elizabeth-Kenkwo-Sams-Club-Project/assets/46757955/f565de45-8234-4f85-83fe-5ce54d4c441c)

##  Screenshots


## Features

- Authentication/Authorization with Spring Security
- CRUD based operations.
- ORM mappings between models.
- Constructing JUnit Testing

## Lessons Learned

What did you learn while building this project? What challenges did you face and how did you overcome them?

- ORM mapping giving me errors due to error in the package imported, I later figured it out after doing some research.
- Spring security restrictions, affecting some of my css styling, change to inline css.
- Searching and sorting models, still trying to figure it out, will update it later due to time constraint.
- Implementing dropdown for some of my fields.


## Run Locally

Clone the project

```bash
  git clone https://github.com/kenkwoelizabeth/Elizabeth-Kenkwo-Sams-Club-Project.git
```


Change the application.properties file to reflect your own environment
```
# Thymeleaf
server.port=8092
spring.thymeleaf.cache=false
spring.thymeleaf.enabled=true
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
# Use MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/storedb?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.username=
spring.datasource.password=
# Specify the database dialect (for MySQL)
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect

spring.jpa.hibernate.ddl-auto=update
logging.level.web=trace
# show queries on console
spring.jpa.show-sql=true
spring.main.allow-circular-references=true
logging.level.org.springframework.web=DEBUG

# Database properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
Install MySQL, then update the username and password in the application.properties
file, create a database call store db

For the users and role if:
firstname is admin during registration, you are assign an admin role
firstname is manager during registration, you are assign a manager role
everything else takes the role of a staff

## Things I need to update later due to time constraint
Dropdowns
Search
Add items to store
Thymeleaf need to add the relationships to the different models
Rectify my testing codes