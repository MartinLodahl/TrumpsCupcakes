use test;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS top;
DROP TABLE IF EXISTS bot;
DROP TABLE IF EXISTS order;
create table user(
username varchar(45) primary key,
password varchar(45),
balance int(100)
);

create table bot(
taste varchar(45) primary key,
price int(2)
);

create table top(
taste varchar(45) primary key,
price int(2)
);

create table order(
FKcupcakeTop varchar(45),
FOREIGN KEY (FKcupcakeTop) REFERENCES top(taste),
FKcupcakeBot varchar(45),
FOREIGN KEY (FKcupcakeBot) REFERENCES bot(taste),
quantity int(10),
price int(12),
FKuserName varchar(45),
FOREIGN KEY (FKuserName) REFERENCES user(username)
);

select * from user;