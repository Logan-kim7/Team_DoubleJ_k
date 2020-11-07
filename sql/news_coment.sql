-- NEWS ?éò?ù¥Ïß? ?ûÖ?ãà?ã§.

CREATE TABLE tbl_newsComment (

        seq	    NUMBER		PRIMARY KEY,
        seqJ	NUMBER	NOT NULL UNIQUE	,
        writer	nVARCHAR2(100)	NOT NULL,	
        dates	VARCHAR2(10)	NOT NULL,	
        times	VARCHAR2(10)	NOT NULL,	
        title	VARCHAR2(10)	NOT NULL,	
        cont	nVARCHAR2(20),		
        likes	NUMBER,		
        views	NUMBER		
);
-- seq_nc = seq
CREATE SEQUENCE seq_nc START WITH 1 INCREMENT BY 1;

DROP TABLE tbl_newsComent;
DROP SEQUENCE seq_nc;

select * from tbl_newscoment;
