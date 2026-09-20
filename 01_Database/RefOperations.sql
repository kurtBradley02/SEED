\echo '--- Create Table ---'
create table if not exists tbl_operations(
	id serial primary key,
	col01 varchar(100) default 'test',
	col02 integer default 0,
	col03 boolean default false,
	col04 timestamp default current_timestamp
);

\echo '--- Insert record ---'
insert into tbl_operations default values;

\echo '--- Show current state ---'
select * from tbl_operations;

\echo '--- Update record ---'
update tbl_operations set col01 = 'updated test' where id = 1;
update tbl_operations set col02 = 1 where id = 1;
update tbl_operations set col03 = true where id = 1;

\echo '--- Show current state ---'
select * from tbl_operations;

\echo '--- Truncate table ---'
truncate table tbl_operations restart identity;

\echo '--- Show current state ---'
select * from tbl_operations;

\echo '--- Insert record ---'
insert into tbl_operations default values;

\echo '--- Show current state ---'
select * from tbl_operations;