drop table if exists publishers;
drop table if exists authors;
drop table if exists titles;
drop table if exists authorISBN;

create table publishers (
	publisherID INT UNSIGNED NOT NULL AUTO_INCREMENT,
	publisherName VARCHAR (30) NOT NULL,
	PRIMARY KEY (publisherID)
);

create table authors (
	authorID INT UNSIGNED NOT NULL AUTO_INCREMENT,
	firstName VARCHAR (20) NOT NULL,
	lastName VARCHAR (30) NOT NULL,
	PRIMARY KEY (authorID)
);

create table titles (
	isbn VARCHAR (20) NOT NULL,
	title VARCHAR (100) NOT NULL,
	editionNumber INT NOT NULL,
	copyright VARCHAR (4) NOT NULL,
	publisherID INT NOT NULL,
	imageFile VARCHAR (20) NOT NULL,
	price real NOT NULL,
	PRIMARY KEY (isbn)
);

create table authorISBN (
	authorID INT NOT NULL,
	isbn VARCHAR (20) NOT NULL
);

insert into publishers (publisherName) values ('CreateSpace Independent')
;
insert into publishers (publisherName) values ('Addison-Wesley Professional')
;
insert into publishers (publisherName) values ('Union Square & Co')
;
insert into publishers (publisherName) values ('Plata Publishing')
;
insert into publishers (publisherName) values ('BlackRose Writing')
;


insert into authors (firstName,lastName) values ('Lewis','Carroll')
;
insert into authors (firstName,lastName) values ('Joshua','Bloch')
;
insert into authors (firstName,lastName) values ('Dale','Carnegie')
;
insert into authors (firstName,lastName) values ('Robert','T.Kiyosaki')
;
insert into authors (firstName,lastName) values ('Joe','Siple')
;


insert into titles (isbn,title,editionNumber,copyright,publisherID,imageFile,price) values ('0134685997','Effective Java',3,'2017',2,'effectivejava.jpg',47.02)
;
insert into titles (isbn,title,editionNumber,copyright,publisherID,imageFile,price) values ('1503222683','Alice Adventures in Wonderland',3,'2020',1,'aliceadventure.jpg',11.94)
;
insert into titles (isbn,title,editionNumber,copyright,publisherID,imageFile,price) values ('1578660394','Life Time Plan for Success',1,'2001',3,'DaleCarnegiebook.jpg',21.99)
;
insert into titles (isbn,title,editionNumber,copyright,publisherID, imageFile,price) values ('1612681131','Rich Dad & Poor Dad',25,'2020',4,'richdad.jpg',7.68)
;
insert into titles (isbn,title,editionNumber,copyright,publisherID,imageFile,price) values ('1684330408','The Five Wishes of Mr.Murray McBride',1,'2018',5,'51wylQRKb3L.jpg',13.79)
;


insert into authorISBN (authorID,isbn) values (1,'1503222683')
;
insert into authorISBN (authorID,isbn) values (2,'0134685997')
;
insert into authorISBN (authorID,isbn) values (3,'1578660394')
;
insert into authorISBN (authorID,isbn) values (4,'1612681131')
;
insert into authorISBN (authorID,isbn) values (5,'1684330408')
;
