create table product(
	product_id int not null,
	product_name varchar(256) not null,
	price decimal not null,
	primary key (product_id)
);

insert into product(product_id, product_name, price) values (1, 'Hammer', 14.99);
insert into product(product_id, product_name, price) values (2, 'Screw driver', 11.99);
insert into product(product_id, product_name, price) values (3, 'Saw', 24.99);
insert into product(product_id, product_name, price) values (4, 'Measuring tape', 10.99);
insert into product(product_id, product_name, price) values (5, 'Nails', 16.98);