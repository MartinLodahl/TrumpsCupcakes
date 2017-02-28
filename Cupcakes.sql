use test;
DROP TABLE IF EXISTS user;
create table user(
username varchar(45) primary key,
password varchar(45),
balance int(100)
);

select * from user;