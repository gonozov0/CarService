create table cars (
  id int(5) PRIMARY KEY AUTO_INCREMENT,
  company varchar(50) NOT NULL,
  model varchar(50) NOT NULL,
  color varchar(50) NOT NULL,
  price int(10) NOT NULL
);
create table stuffs (
  id int primary key auto_increment,
  name varchar NOT NULL,
  type varchar not null,
  price int not null
);