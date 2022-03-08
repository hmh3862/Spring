drop table people;
create table people (
id int primary key auto_increment,
first_name varchar(20) not null,
last_name varchar(20) not null,
age int not null
);

insert into people (id, first_name, last_name, age) values
(0, 'Vlad', 'Boyarskiy', 21),
(0,'Oksi', ' Bahatskaya', 30),
(0,'Vadim', ' Vadimich', 32);

select * from people;
commit;

create table STUDENT (
   id INT NOT NULL auto_increment PRIMARY KEY,
   first_name VARCHAR(30) NOT NULL,
   last_name  VARCHAR(30) NOT NULL,
   section    VARCHAR(30) NOT NULL
);

select * from student;