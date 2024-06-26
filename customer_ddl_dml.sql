CREATE TABLE IF NOT EXISTS customerinfo (
  customer_id bigserial PRIMARY KEY,
  customer_name varchar(50),
  customer_address varchar(100),
  customer_dob date,
  iban_number varchar(25),	
  username varchar(10),
  password varchar(10)
);
