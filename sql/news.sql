-- NEWS 페이지 입니다.





CREATE TABLE tbl_newsR  (
    seq	NUMBER		PRIMARY KEY,
	dates	VARCHAR2(10)	NOT NULL,	
    title	VARCHAR2(10)	NOT NULL,	
	img nVARCHAR2(1300),		
	cont nVARCHAR2(1300)			
    );
    
    
CREATE SEQUENCE seq_newsR START WITH 1 INCREMENT BY 1;
    
    
    
    




CREATE TABLE tbl_newsC (

        seq	NUMBER		PRIMARY KEY,
        seqC	NUMBER	NOT NULL UNIQUE	,
        writer	nVARCHAR2(100)	NOT NULL,	
        dates	VARCHAR2(10)	NOT NULL,	
        time	VARCHAR2(10)	NOT NULL,	
        title	VARCHAR2(10)	NOT NULL,	
        cont	nVARCHAR2(20),		
        likes	NUMBER,		
        views	NUMBER		


);


CREATE SEQUENCE seq_newsC START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_newsC START WITH 1 INCREMENT BY 1;


DROP TABLE tbl_newsC;

DROP SEQUENCE seq_newsC;
