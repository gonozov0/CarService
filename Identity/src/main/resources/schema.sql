create table users (
  id int(5) PRIMARY KEY Auto_increment,
  login varchar(50) not null,
  password varchar(50) not null,
  role varchar(10) not null
);