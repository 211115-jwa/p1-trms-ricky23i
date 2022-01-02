/*insert into user_role(role_id, role_name)
values(default,'employee'),
(default,'direct supervisor'),
(default, 'deparment head'),
(default, 'benefits coordinator');
*/
--select * from user_role;
/*insert into event_type(type_id, type_name, percent_coverage)
values(default,'university course','80'),
(default,'seminars','60'),
(default,'certification preperation classes','75'),
(default,'certification','100'),
(default,'technical training','90'),
(default,'other','30');
select * from event_type;

insert into status(status_id,status_name,approver)
values(default, 'pending approval','direct supervisor'),
(default, 'approved','direct supervisor'),
(default, 'denied','direct supervisor'),
(default, 'pending approval','department head'),
(default, 'approved','department head'),
(default, 'denied','department head'),
(default, 'pending approval','benefits coordinator'),
(default, 'approved','benefits coordinator'),
(default, 'denied','benefits coordinator');
select * from status;
*/
/*
insert into department(dept_id,dept_name,dept_head_id)
values(default,'Engineers',null),
(default,'WareHouse',null);
*/
/*insert into comment(comment_id,req_id,approver_id,comment_text,sent_at)
values(default,'1','5','required event','30 Dec 2021');
*/
/*
insert into employee(emp_id,first_name,last_name,username,passwd,role_id,funds,supervisor_id,dept_id)
values(default,'War','Sup','warsup','super123','2','800',null,'2'),
(default,'War','Head','warhead','dept123','3','0',null,'2'),
(default, 'War','Emp','waremp','pass123','1','1000',null,'2'),
(default,'War','coord','warcoord','coord123','4','200',null,'2');
*/

/*insert into grading_format(format_id,format_name,example)
values(default,'Grade','75'),
(default,'Pass/Fail','Pass/Fail'),
(default,'Presentation','Presented'),
(default,'Other','Other');
*/
/*insert into reimbursement(req_id,emp_id,event_date,event_time,location,description,cost,grading_format_id,event_type_id,status_id,submitted_at)
values(default,'4','15 Jan 2022','08:00:00','Remote','required seminar','200', '4','2','8','30 Dec 2021');
*/
--update department set dept_head_id = '4' where dept_id ='1';
--update department set dept_head_id = '7' where dept_id ='2';
/*
select * from department;
select * from employee; 
select * from department;
select * from event_type;
select * from grading_format;
select * from status;
select * from user_role;
select * from comment;
select * from reimbursement;
*/
--commit;