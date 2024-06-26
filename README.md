# Steps to setup ABC Bank application
# Create a Database or table from the SQL file : /customer-onboarding/customer_ddl_dml.sql
# Checkout the project local folder (unzip) and configure (Import as Existing Maven project) in Eclipse
# Change the application.properties for database configuration -
  # database url
  # database username
  # database password
  # database dialect for respective database (we used PostgresSQL Dialect)
# Run the project - right click CustomerOnboardingApplication.java - Run as Java Application
  # Spring Boot application will be started
# Access the URL - http://locahost:8080/register in POSTMAN by passing the Request Parameter as below format:
  {
    "customerName" : "Sivalingam",
    "customerAddress" : "1012 South Street, Bangalore, KA, India",
    "customerDob" : "2024-06-10"
 }
