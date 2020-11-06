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
CREATE SEQUENCE seq_news START WITH 1 INCREMENT BY 1;


INSERT INTO tbl_newsc
VALUES (seq_news.nextval,seq_newsC.nextval, '홍길동','1','1','워','춥습니다','1','1');
commit;

SELECT * FROM tbl_newsc;