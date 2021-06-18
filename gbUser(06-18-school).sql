CREATE DATABASE school;

USE school;

CREATE TABLE tbl_student (
	
	st_num	CHAR(8) 	PRIMARY KEY,
	st_name	VARCHAR(20)	NOT NULL,	
	st_dept	VARCHAR(20)	NOT NULL,	
	st_grade int	NOT NULL,	
	st_tel	VARCHAR(15)	NOT NULL,	
	st_addr	VARCHAR(125)		
);

DROP TABLE tbl_student;

insert into tbl_student(st_num, st_name, st_dept, st_grade, st_tel)
values('20210001','홍길동', '컴퓨터공학', 2, '010-111');

CREATE TABLE tbl_score (

	sc_seq	BIGINT auto_increment PRIMARY KEY,
	sc_stnum	CHAR(8)	NOT NULL,	
	sc_subject	VARCHAR(20)	NOT NULL,	
	sc_score	INT	NOT NULL	
);
DROP TABLE tbl_score;



insert into tbl_score(sc_stnum, sc_subject, sc_score)
values('20210001', '국어', 90);
