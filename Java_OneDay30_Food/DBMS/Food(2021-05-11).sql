--food 접속

-- 식품정보 tbl 생성
CREATE TABLE tbl_foods(
    fd_pdcode	CHAR(7)		PRIMARY KEY,
    fd_fname	NVARCHAR2(50)	NOT NULL,
    fd_date	NUMBER NOT NULL,
    fd_ccode	CHAR(6)	NOT NULL,	
    fd_tcode	CHAR(4)	NOT NULL,
    fd_onegift	NUMBER	NOT NULL,	
    fd_totalgram	NUMBER	NOT NULL,
    fd_kcal	NUMBER	NOT NULL,	
    fd_dan	NUMBER	NOT NULL,	
    fd_ge	NUMBER	NOT NULL,	
    fd_tan	NUMBER	NOT NULL,
    fd_suger	NUMBER	NOT NULL	
   
);

-- 제조사 tbl 생성
CREATE TABLE tbl_company (

    cp_code	CHAR(6)		PRIMARY KEY,
    cp_name	VARCHAR2(100)	NOT NULL	
  
);

DROP TABLE tbl_company;

-- 식품분류 tbl 생성
CREATE TABLE tbl_items (

    it_code	CHAR(4)		PRIMARY KEY,
    it_tname	NVARCHAR2(20)	NOT NULL	
    
);

-- 외래키 설정
ALTER TABLE tbl_foods -- fk 설정 table
ADD CONSTRAINT fk_comp -- fk 이름설정
FOREIGN KEY (fd_ccode) -- child 칼럼
REFERENCES tbl_company(cp_code); --parent 칼럼

ALTER TABLE tbl_foods -- fk 설정 table
ADD CONSTRAINT fk_item -- fk이름 설정
FOREIGN KEY (fd_tcode)
REFERENCES tbl_items(it_code);

-- view 생성
CREATE VIEW view_식품정보 AS
(
    SELECT FD.fd_pdcode AS 상품코드, FD.fd_fname AS 상품명,
            FD.fd_date AS 연도, CP.cp_code AS 제조사코드, CP.cp_name AS 제조사명,
            IT.it_code AS 분류코드, IT.it_tname AS 분류명, 
            FD.fd_onegift AS 일회제공량, FD.fd_totalgram AS 총내용량,
            FD.fd_kcal AS 열량, FD.fd_dan AS 단백질, FD.fd_ge AS 지방,
            FD.fd_tan AS 탄수화물, FD.fd_suger AS 총당류
            
    FROM tbl_foods FD
        LEFT JOIN tbl_company CP
            ON fd_ccode = cp_code
        LEFT JOIN tbl_items IT
            ON fd_tcode = it_code
  
);   

CREATE TABLE tbl_myfoods (

    mf_date VARCHAR2(10) NOT NULL,
    mf_pdcode CHAR(7) NOT NULL,
    mf_eat NUMBER NOT NULL
);

INSERT INTO tbl_myfoods (mf_date, mf_pdcode, mf_eat)
VALUES ('2021-05-09', 'PD00017', 1);

INSERT INTO tbl_myfoods (mf_date, mf_pdcode, mf_eat)
VALUES ('2021-05-09', 'PD00102', 2);

INSERT INTO tbl_myfoods (mf_date, mf_pdcode, mf_eat)
VALUES ('2021-05-09', 'PD00222', 1);

INSERT INTO tbl_myfoods (mf_date, mf_pdcode, mf_eat)
VALUES ('2021-05-09', 'PD01001', 1);


SELECT *
FROM tbl_myfoods MF
    LEFT JOIN tbl_foods FD
        ON MF.mf_pdcode = FD.fd_pdcode;

CREATE VIEW view_섭취정보 AS
(
    SELECT MF.mf_date AS 날짜, FD.fd_fname AS 식품명, MF.mf_pdcode AS 식품코드, 
            MF.mf_eat AS 섭취량,
            ROUND ( FD.fd_kcal * MF.mf_eat) AS 총칼로리,
            ROUND ( FD.fd_tan * MF.mf_eat) AS 탄수화물,
            ROUND ( FD.fd_dan * MF.mf_eat) AS 단백질,
            ROUND ( FD.fd_ge * MF.mf_eat) AS 지방,
            ROUND ( FD.fd_suger * MF.mf_eat) AS 당류
    FROM tbl_myfoods MF
        LEFT JOIN tbl_foods FD
            ON MF.mf_pdcode = FD.fd_pdcode
);
DROP VIEW view_식품정보;
