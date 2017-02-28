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

INSERT INTO bot(taste, price) 
values
("Chocolate", 5),
("Vanilla", 5),
("Nutmeg", 5),
("Pistacio", 6),
("Almond", 7);

create table top(
taste varchar(45) primary key,
price int(2)
);

INSERT INTO top(taste, price) 
values
("Chocolate", 5),
("Blueberry", 5),
("Rasberry", 5),
("Crispy", 6),
("Stawberry", 6),
("Rum/Raisin", 7),
("Orange", 8),
("Lemon", 8),
("Blue cheese", 9);

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