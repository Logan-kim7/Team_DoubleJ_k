-- NEWS ?éò?ù¥Ïß? ?ûÖ?ãà?ã§.

CREATE TABLE tbl_newsComent (

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

DROP TABLE tbl_newsC;
DROP SEQUENCE seq_newsC;
