CREATE TABLE tbl_newsList  (
    seq	NUMBER		PRIMARY KEY,
	dates	VARCHAR2(10)	NOT NULL,	
    title	nVARCHAR2(200)	NOT NULL,	
	img nVARCHAR2(1300),		
	cont CLOB			
    );
CREATE SEQUENCE seq_newsList START WITH 1 INCREMENT BY 1;

drop table tbl_newsList;
drop sequence seq_newsList;

select * from tbl_newslist;

commit;