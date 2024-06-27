# Steps to setup ABC Bank application
  *1. Create a Database or table from the SQL file : /customer-onboarding/customer_ddl_dml.sql*
  *2. Checkout the project local folder (unzip) and configure (Import as Existing Maven project) in Eclipse*
  *3. Change the application.properties for database configuration -*
      database url
      database username
      database password
      database dialect for respective database (we used PostgresSQL Dialect)
  *4. Run the project - right click CustomerOnboardingApplication.java - Run as Java Application*
   Spring Boot application will be started
  *5. Access the URL for CUSTOMER REGISTER - http://locahost:8080/api/register in POSTMAN by passing the Request Parameter as below format:*
      {
         customerName : 'Sivalingam',
         customerAddress : '1012 South Street, Bangalore, KA, India',
         customerDob : '2024-06-10'
         username : 'sivalingmca'
      }
  *6. Access the URL for CUSTOMER LOGIN - http://locahost:8080/api/login in POSTMAN by passing the Request Parameter as below format:*
      {
         username : 'sivalingmca',
         password : '<GENERATED_PASSWORD_FROM_PREVIOUS_RESPONSE>'
      }
