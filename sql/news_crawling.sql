CREATE TABLE tbl_newsList  (
    seq	NUMBER		PRIMARY KEY,
	dates	VARCHAR2(10)	NOT NULL,	
    title	VARCHAR2(10)	NOT NULL,	
	img nVARCHAR2(1300),		
	cont nVARCHAR2(1300)			
    );
CREATE SEQUENCE seq_newsR START WITH 1 INCREMENT BY 1;
drop table tbl_newsR;