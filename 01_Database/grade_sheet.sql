create table tbl_students(
	student_id serial primary key,
	student_name varchar(100) default 'student',
	student_grade integer default 75,
	record_date timestamp default current_timestamp
);

insert into tbl_students default values;

select * from tbl_students;