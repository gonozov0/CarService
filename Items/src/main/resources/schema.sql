create table items (
  id int(5) PRIMARY KEY AUTO_INCREMENT,
  company varchar(50),
  model varchar(50),
  color varchar(50),
  price int(10),
  name varchar(50),
  type varchar(50),
  isCar bit not null
);