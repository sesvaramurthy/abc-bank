
# ABC Bank

# Steps to setup ABC Bank application
  *1. Create a Database or table from the SQL file : /abc-bank/customer_ddl_dml.sql* 

  *2. Checkout the project local folder (unzip) and configure (Import as Existing Maven project) in Eclipse*

  *3. Change the application.properties for database configuration - according to your <database>*
  
      spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
      spring.datasource.username=postgres
      spring.datasource.password=postgres
      spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

  *4. To Run the project - right click CustomerApplication.java - Run as Java Application* Spring Boot application will be started
      
  *5. Swagger API docs URL*
  
      http://localhost:8080/swagger-ui/index.html

  *6. Access the URL for CUSTOMER REGISTER - by passing the Request Parameter as below format:*

      http://localhost:8080/api/register
      {
         customerName : 'Sivalingam',
         customerAddress : '1012 South Street, Bangalore, KA, India',
         customerDob : '2024-06-10'
         username : 'sivalingmca'
      }

  *6. Access the URL for CUSTOMER LOGIN - by passing the Request Parameter as below format:*

      http://localhost:8080/api/login
      {
         username : 'sivalingmca',
         password : '<GENERATED_PASSWORD_FROM_PREVIOUS_RESPONSE>'
      }
      


