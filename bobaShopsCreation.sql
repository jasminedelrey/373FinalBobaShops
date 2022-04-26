CREATE DATABASE bobaShops;
USE bobaShops;
CREATE TABLE Boba (
	Boba_id int,
	Name varchar(50) not null,
	Price decimal(3, 1),
	Primary key(boba_id)
);
/* FIXME: add unique_id for Employee table */

CREATE TABLE Employee ( 
	Home_store_id int,
	emp_id int not null,
	name varchar(50) not null,
	Phone int,
    email varchar(50) not null, 
	Address varchar(50) not null,
    PRIMARY KEY (emp_id)
);
CREATE TABLE Inventory (
	Store_id int,
	Ingredient_id int,
	Quantity int,
	Primary key (store_id, ingredient_id)
);
/* removed number as primary key*/
CREATE TABLE Member (
	Member_id int,	
    Name varchar(50) not null,
	Phone int,
	Email varchar(50) not null,
	Address varchar(50) not null,
    date_init DATE,
    Primary key (Member_id));
/* fixed primary key to purchase id*/
CREATE TABLE Purchase (
	Purchase_id int,
	Date datetime,
	Boba_id int,
	Quantity int,
	Price decimal(3, 1),
	member_id int,
	isMember boolean,
	Store_id int,
	Primary key(Purchase_id, boba_id),
    Foreign Key(member_id) references Member(member_id));

/* FIXME: allow for suplicate boba_id*/
CREATE TABLE Recipe (
    Store_id int,
	Ingredient_id int,
	iquantity int,
	Boba_id int,
	Primary key (store_id, boba_id),
	Foreign key (boba_id) references Boba(boba_id)
);

CREATE TABLE Store (
	Store_id int,
	Name varchar(50) not null,
	Email varchar(50) not null,
	Address varchar(50) not null,
	Primary key (store_id),
	Foreign key (store_id) REFERENCES Inventory(store_id)
);


/* Order_id is unique to each ingredient shipment
 Shipment_number can have duplicates as shipment can have multiple ingredients */

CREATE TABLE Shipment (
	Order_id int,
	Shipment_number int,
	Ingredient_id int,
	Quantity int NOT NULL,
	Store_id int,
	Date datetime,
	Primary key (Order_id),
    Foreign Key (store_id, ingredient_id) references INVENTORY(store_id, ingredient_id));
	
INSERT INTO Inventory (store_id, ingredient_id, quantity) values (40, 1, 20);
INSERT INTO Inventory (store_id, ingredient_id, quantity) values (41, 2, 50);
INSERT INTO Inventory (store_id, ingredient_id, quantity) values (42, 3, 67);
INSERT INTO Inventory (store_id, ingredient_id, quantity) values (43, 4, 28);
INSERT INTO Inventory (store_id, ingredient_id, quantity) values (44, 5, 53);
INSERT INTO Inventory (store_id, ingredient_id, quantity) values (45, 6, 30);
INSERT INTO Inventory (store_id, ingredient_id, quantity) values (46, 7, 12);
INSERT INTO Inventory (store_id, ingredient_id, quantity) values (47, 8, 32);
INSERT INTO Inventory (store_id, ingredient_id, quantity) values (48, 9, 40);

INSERT INTO Store (store_id, name, Email, address) values (40, 'Beverly Hills Boba', 'bhills@teanfriends.com', '123 Sherwood Road');
INSERT INTO Store (store_id, name, Email, address) values (41, 'Echo Park Boba', 'echo@teanfriends.com', '456 Short Street');
INSERT INTO Store (store_id, name, Email, address) values (42, 'Eagle Rock Boba', 'eaglerock@teanfriends.com', '678 St Michaels Road');
INSERT INTO Store (store_id, name, Email, address) values (43, 'Carthay Boba', 'carthay@teanfriends.com', '890 Silver Avenue');
INSERT INTO Store (store_id, name, Email, address) values (44, 'Atwater Village Boba', 'atwater@teanfriends.com', '876 Hart Row');
INSERT INTO Store (store_id, name, Email, address) values (45, 'Boyle Heights Boba', 'boyleh@teanfriends.com', '654 Central Boulevard');
INSERT INTO Store (store_id, name, Email, address) values (46, 'Chinatown Boba', 'chinatown@teanfriends.com', '432 North Route');
INSERT INTO Store (store_id, name, Email, address) values (47, 'Arts District Boba', 'artsd@teanfriends.com', '153 Moon Lane');
INSERT INTO Store (store_id, name, Email, address) values (48, 'Brentwood Boba', 'brentwood@teanfriends.com', '285 Monument Avenue');

INSERT INTO Boba (Boba_id, name, price) values (1, 'Strawberry Yakult', 4.5);
INSERT INTO Boba (Boba_id, name, price) values (2, 'Hibiscus Fresh Tea', 4.5);
INSERT INTO Boba (Boba_id, name, price) values (3, 'Osmanthus Tea', 5);
INSERT INTO Boba (Boba_id, name, price) values (4, 'Honey Green Tea', 5.5);
INSERT INTO Boba (Boba_id, name, price) values (5, 'Black Oolong Tea', 5);
INSERT INTO Boba (Boba_id, name, price) values (6, 'Taro', 4.5);
INSERT INTO Boba (Boba_id, name, price) values (7, 'Thai Tea', 4.5);
INSERT INTO Boba (Boba_id, name, price) values (8, 'Passionfruit Green Tea', 4.2);
INSERT INTO Boba (Boba_id, name, price) values (9, 'Oreo Cookie Smoothie', 4.5);
INSERT INTO Boba (Boba_id, name, price) values (10, 'Jasmine Milk Tea', 4.5);

INSERT INTO Employee (Home_store_id, emp_id, name, phone, email, address) values (40, 1234, 'Jane Doe', 8769999, 'abc@aol.com' , '75 W. Lake Street, Dorchester Center, MA 02124');
INSERT INTO Employee (Home_store_id, emp_id, name, phone, email, address) values (45, 1235, 'Alyssa Roach', 3725837, 'def@gmail.com' , '81 Third St. Brick, NJ 08723');
INSERT INTO Employee (Home_store_id, emp_id, name, phone, email, address) values (45, 1236, 'Teagan Logan', 1829432, 'ghi@yahoo.com' , '638 E. Plymouth Rd. Newton, NJ 07860');
INSERT INTO Employee (Home_store_id, emp_id, name, phone, email, address) values (42, 1237, 'Valerie Smith', 1234567, 'vsmith@gmail.com' , '7452 Linden Court Pompano Beach, FL 33060');
INSERT INTO Employee (Home_store_id, emp_id, name, phone, email, address) values (43, 1238, 'Mable Terry', 9992929, 'mterry@gmail.com' , '82 Nichols Street Haines City, FL 33844');
INSERT INTO Employee (Home_store_id, emp_id, name, phone, email, address) values (44, 1239, 'Darrel Weaver', 4728881, 'dweaver@outlook.com' , '768 Whitemarsh Lane Rocky Mount, NC 27804');
INSERT INTO Employee (Home_store_id, emp_id, name, phone, email, address) values (41, 1240, 'Phillip Brewer', 4922453, 'pbrewer@aol.com' , '212 Wild Rose St. Westland, MI 48185');
INSERT INTO Employee (Home_store_id, emp_id, name, phone, email, address) values (48, 1241, 'Angelina Reid', 7078904, 'areid@yahoo.com' , '9939 Lyme Lane Amityville, NY 11701');
INSERT INTO Employee (Home_store_id, emp_id, name, phone, email, address) values (40, 1242, 'Rhonda Doyle', 1426521, 'rdoyle@gmail.com' , '689 Pin Oak Circle Fredericksburg, VA 22405');

INSERT INTO Member (member_id, name, phone, email, address, date_init) values (227493, 'Jane Doe', 8769999, 'abc@aol.com' , '51 Jennings St.
Ponte Vedra Beach, FL 32082' ,str_to_date('01-01-2022','%m-%d-%Y') );
INSERT INTO Member (member_id, name, phone, email, address, date_init) values (417382, 'Alyssa Roach', 3725837, 'def@gmail.com' ,'52 Broad St.
Chambersburg, PA 17201' ,str_to_date('01-02-2022','%m-%d-%Y'));
INSERT INTO Member (member_id, name, phone, email, address, date_init) values (365848, 'Teagan Logan', 1829432, 'ghi@yahoo.com' ,'9839 Lincoln Road
Jacksonville, NC 28540' ,str_to_date('02-20-2020','%m-%d-%Y'));
INSERT INTO Member (member_id, name, phone, email, address, date_init) values (120284, 'Elliot Wilcox', 9394868, 'jkl@hotmail.com' , '881 College St.
Carpentersville, IL 60110', str_to_date('04-05-2021','%m-%d-%Y'));
INSERT INTO Member (member_id, name, phone, email, address, date_init) values (923853, 'Tyler Austin', 4892933, 'mno@gmail.com' , '36 St Louis Court
Ravenna, OH 44266', str_to_date('02-02-2022','%m-%d-%Y'));
INSERT INTO Member (member_id, name, phone, email, address, date_init) values (502039, 'Orion Mccoy', 1393331, 'pqr@outlook.com' , '7191 East Cherry Hill Street
Wheeling, WV 26003',str_to_date('09-04-2020','%m-%d-%Y'));
INSERT INTO Member (member_id, name, phone, email, address, date_init) values (NULL, 'null', NULL, NULL, NULL,NULL);

ALTER TABLE Purchase Add Foreign key (boba_id) REFERENCES Boba(boba_id);

INSERT INTO Purchase (Purchase_id, Date, Boba_id, Quantity, Price, member_id , isMember , Store_id) values ( 890, str_to_date('03-05-2022','%m-%d-%Y'), 1, 3, 13.5, 227493, True, 10);
INSERT INTO Purchase (Purchase_id, Date, Boba_id, Quantity, Price, member_id , isMember , Store_id) values ( 890, str_to_date('03-03-2022','%m-%d-%Y'), 2, 1, 4.5, 417382, True, 10);
INSERT INTO Purchase (Purchase_id, Date, Boba_id, Quantity, Price, member_id , isMember , Store_id) values ( 890, str_to_date('03-03-2022','%m-%d-%Y'), 3, 1, 4.5, 227493, True, 10);
INSERT INTO Purchase (Purchase_id, Date, Boba_id, Quantity, Price, member_id , isMember , Store_id) values ( 890, str_to_date('03-03-2022','%m-%d-%Y'), 4, 2, 9, 365848, True, 10);
INSERT INTO Purchase (Purchase_id, Date, Boba_id, Quantity, Price, member_id , isMember , Store_id) values ( 632, str_to_date('02-27-2022','%m-%d-%Y'), 2, 1, 4.5, 923853, True, 8);
INSERT INTO Purchase (Purchase_id, Date, Boba_id, Quantity, Price, member_id , isMember , Store_id) values ( 345, str_to_date('02-28-2022','%m-%d-%Y'), 5, 2, 9, 120284, True, 9);
INSERT INTO Purchase (Purchase_id, Date, Boba_id, Quantity, Price, member_id , isMember , Store_id) values ( 105, str_to_date('02-20-2022','%m-%d-%Y'), 2, 3, 13.5, 502039, True, 7);

ALTER TABLE Member Add Foreign key (Member_id) REFERENCES Purchase(Member_id);
/* need to fix foreign key to allow null for member_id
INSERT INTO Purchase (Purchase_id, Date, Boba_id, Quantity, Price, member_id , isMember , Store_id) values ( 567, str_to_date('03-01-2022','%m-%d-%Y'), 2, 4, 18, NULL, False, 11);
INSERT INTO Purchase (Purchase_id, Date, Boba_id, Quantity, Price, member_id , isMember , Store_id) values ( 567, str_to_date('03-01-2022','%m-%d-%Y'), 3, 1, 4.5, NULL, False, 11);
INSERT INTO Purchase (Purchase_id, Date, Boba_id, Quantity, Price, member_id , isMember , Store_id) values ( 374, str_to_date('02-28-2022','%m-%d-%Y'), 1, 1, 4.5, NULL, False, 8);
*/



INSERT INTO Recipe (Store_id, Ingredient_id, iquantity, Boba_id) values (48, 3, 3, 1);
INSERT INTO Recipe (Store_id, Ingredient_id, iquantity, Boba_id) values (41, 7, 1, 2);
INSERT INTO Recipe (Store_id, Ingredient_id, iquantity, Boba_id) values (47, 8, 1, 2);
INSERT INTO Recipe (Store_id, Ingredient_id, iquantity, Boba_id) values (46, 3, 2, 3);
INSERT INTO Recipe (Store_id, Ingredient_id, iquantity, Boba_id) values (44, 6, 3, 3);
INSERT INTO Recipe (Store_id, Ingredient_id, iquantity, Boba_id) values (48, 5, 2, 4);
INSERT INTO Recipe (Store_id, Ingredient_id, iquantity, Boba_id) values (43, 8, 1, 4);
INSERT INTO Recipe (Store_id, Ingredient_id, iquantity, Boba_id) values (42, 3, 1, 4);
INSERT INTO Recipe (Store_id, Ingredient_id, iquantity, Boba_id) values (46, 1, 1, 5);
INSERT INTO Recipe (Store_id, Ingredient_id, iquantity, Boba_id) values (40, 7, 3, 5);
INSERT INTO Recipe (Store_id, Ingredient_id, iquantity, Boba_id) values (44, 9, 2, 5);
INSERT INTO Recipe (Store_id, Ingredient_id, iquantity, Boba_id) values (45, 2, 7, 6);
INSERT INTO Recipe (Store_id, Ingredient_id, iquantity, Boba_id) values (48, 3, 2, 7);
INSERT INTO Recipe (Store_id, Ingredient_id, iquantity, Boba_id) values (42, 4, 1, 7);
INSERT INTO Recipe (Store_id, Ingredient_id, iquantity, Boba_id) values (40, 5, 4, 8);
INSERT INTO Recipe (Store_id, Ingredient_id, iquantity, Boba_id) values (44, 4, 2, 9);
INSERT INTO Recipe (Store_id, Ingredient_id, iquantity, Boba_id) values (41, 8, 1, 9);
INSERT INTO Recipe (Store_id, Ingredient_id, iquantity, Boba_id) values (42, 5, 6, 10);

/* need to fix to allow ingredients that the store doesn't already have */
INSERT INTO Shipment (Order_id, Shipment_number, Ingredient_id, Quantity, Store_id, Date) values (521, 263, 1, 20,40,  str_to_date('01-20-2022','%m-%d-%Y'));
INSERT INTO Shipment (Order_id, Shipment_number, Ingredient_id, Quantity, Store_id, Date) values (522, 876, 2, 40,41,  str_to_date('01-02-2022','%m-%d-%Y'));
INSERT INTO Shipment (Order_id, Shipment_number, Ingredient_id, Quantity, Store_id, Date) values (523, 543, 3, 10,42,  str_to_date('02-4-2022','%m-%d-%Y'));
INSERT INTO Shipment (Order_id, Shipment_number, Ingredient_id, Quantity, Store_id, Date) values (524, 567, 4, 20,43,  str_to_date('02-14-2022','%m-%d-%Y'));
INSERT INTO Shipment (Order_id, Shipment_number, Ingredient_id, Quantity, Store_id, Date) values (525, 789, 5, 30,44,  str_to_date('02-20-2022','%m-%d-%Y'));
INSERT INTO Shipment (Order_id, Shipment_number, Ingredient_id, Quantity, Store_id, Date) values (526, 263, 5, 35,44,  str_to_date('02-26-2022','%m-%d-%Y'));
INSERT INTO Shipment (Order_id, Shipment_number, Ingredient_id, Quantity, Store_id, Date) values (527, 876, 6, 55,45,  str_to_date('03-01-2022','%m-%d-%Y'));
INSERT INTO Shipment (Order_id, Shipment_number, Ingredient_id, Quantity, Store_id, Date) values (528, 543, 9, 50,48,  str_to_date('03-01-2022','%m-%d-%Y'));

ALTER TABLE Member Add Foreign key (Member_id) REFERENCES Purchase(Member_id);

SELECT * FROM Store;
SELECT * FROM Member;
SELECT * FROM Purchase;
SELECT * FROM Recipe;
SELECT * FROM Shipment;
SELECT * FROM Employee;
SELECT * FROM Boba;
SELECT * FROM Store;
SELECT * FROM Inventory;

