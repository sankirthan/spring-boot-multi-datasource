create table customer(
	customer_id int not null,
	first_name varchar(128) not null,
	last_name varchar(128) not null,
	primary key (customer_id)
);

insert into customer(customer_id, first_name, last_name) values (1, 'Kevin', 'Keller');
insert into customer(customer_id, first_name, last_name) values (2, 'Jason', 'Cook');
insert into customer(customer_id, first_name, last_name) values (3, 'Nicole', 'Hudson');
insert into customer(customer_id, first_name, last_name) values (4, 'Albert', 'Marshall');
insert into customer(customer_id, first_name, last_name) values (5, 'Evelyn', 'Shultz');