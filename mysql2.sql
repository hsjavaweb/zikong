 create  table student_information(
 id int primary key auto_increment,
 stu_name varchar(10),
 stu_sex enum('male','female','secret'),
 stu_age tinyint unsigned,
 stu_id int
 )character set gbk;--姓名，性别，年龄，学号
 --增加数据
 
insert into student_information values 
(null,'紫空','male',18,20170901),
(null,'一灯','male',28,20170902),
(null,'皋鸿','male',38,20170903),
(null,'诗芹','female',48,20170904),
(null,'诗音','female',58,20170905),
(null,'伯通','secret',68,20170906);
 --删除数据
delete from student_information where stu_sex='secret';
--修改数据
update student_information set stu_id=20171000 where stu_age>=50;
--查询数据
select stu_id from student_information where stu_id<20171000;
