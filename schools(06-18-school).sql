
CREATE TABLE tbl_student (
    st_num	CHAR(8)		PRIMARY KEY,
    st_name	NVARCHAR2(20)	NOT NULL,	
    st_dept	NVARCHAR2(20)	NOT NULL,	
    st_grade NUMBER	NOT NULL,	
    st_tel	VARCHAR2(15)	NOT NULL,	
    st_addr	NVARCHAR2(125)		



);

CREATE TABLE tbl_score (

    sc_seq	CHAR(8)		PRIMARY KEY,
    sc_stnum	CHAR(8)	NOT NULL,	
    sc_subject	nVARCHAR2(20)	NOT NULL,	
    sc_score	NUMBER	NOT NULL	
);


CREATE SEQUENCE seq_num
    INCREMENT BY 1 
    START WITH 0001;
    
INSERT INTO tbl_student(st_num, st_name, st_dept, st_grade, st_tel)
VALUES(seq_num.NEXTVAL, '홍길동', '컴퓨터공학', 2, '010');

ALTER TABLE tbl_score
ADD CONSTRAINT fk_student
FOREIGN KEY (sc_seq)
REFERENCES tbl_student(st_num);




