-- NEWS ?ï¿½ï¿½?ï¿½ï¿½ï¿?? ?ï¿½ï¿½?ï¿½ï¿½?ï¿½ï¿½.

CREATE TABLE tbl_newsComment (

        seq	    NUMBER		PRIMARY KEY,
        seqJ	NUMBER	NOT NULL,
        writer	nVARCHAR2(100)	NOT NULL,	
        dates	nVARCHAR2(10)	NOT NULL,	
        times	nVARCHAR2(10)	NOT NULL,	
        title	nVARCHAR2(10)	NOT NULL,	
        cont	nVARCHAR2(20),		
        likes	NUMBER,		
        views	NUMBER		
);
-- seq_nc = seq
CREATE SEQUENCE seq_nc START WITH 1 INCREMENT BY 1;

DROP TABLE tbl_newsComment;
DROP SEQUENCE seq_nc;

select * from tbl_newscoment;
