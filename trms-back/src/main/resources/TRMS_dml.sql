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