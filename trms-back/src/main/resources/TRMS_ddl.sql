drop table if exists reimbursement cascade;
drop table if exists employee cascade;
drop table if exists event_type cascade;
drop table if exists grading_format cascade;
drop table if exists status cascade;
drop table if exists comment cascade ;
drop table if exists department cascade ;
drop table if exists user_role cascade;

create  table if not exists event_type(
	type_id serial primary key,
	type_name varchar(100) not null,
	percent_coverage integer not null
);

create table if not exists grading_format(
	format_id serial primary key,
	format_name varchar(100) not null,
	example varchar(200) not null
);

create table if not exists status(
	status_id serial primary key,
	status_name varchar(100) not null,
	approver varchar(100) not null
);

create table if not exists user_role(
	role_id serial primary key,
	role_name varchar(100) not null
);

create table if not exists department(
	dept_id serial primary key,
	dept_name varchar(100) not null,
	dept_head_id integer 
);
create table if not exists employee(
	emp_id serial primary key,
	first_name varchar(100) not null,
	last_name varchar(100) not null,
	username varchar(150) not null,
	passwd varchar(150) not null,
	role_id integer not null references user_role(role_id),
	funds integer not null,
	supervisor_id integer references employee(emp_id),
	dept_id integer not null references department(dept_id)
);


alter table if exists department
add foreign key(dept_head_id) references employee(emp_id);

create table if not exists reimbursement(
	req_id serial primary key,
	emp_id integer not null references employee(emp_id),
	event_date date not null,
	event_time time not null,
	location varchar(100) not null,
	description varchar(200) not null,
	cost integer not null,
	grading_format_id integer not null references grading_format(format_id),
	event_type_id integer not null  references event_type(type_id),
	status_id integer not null references status(status_id),
	submitted_at date not null
);


create table if not exists comment(
	comment_id serial primary key,
	req_id integer not null references reimbursement(req_id),
	approver_id integer not null references employee(emp_id),
	comment_text varchar(200),
	sent_at date not null
);
