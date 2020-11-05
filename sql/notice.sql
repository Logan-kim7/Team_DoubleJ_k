CREATE TABLE tbl_notice
(
    seq	    NUMBER		    PRIMARY KEY,
    writer	nVARCHAR2(100)	NOT NULL,
    dates	VARCHAR2(10)	NOT NULL,	
    times	VARCHAR2(10)	NOT NULL,	
    title	VARCHAR2(10)	NOT NULL,	
    cont	nVARCHAR2(20),
    likes	NUMBER		,
    views	NUMBER		
);

CREATE SEQUENCE seq_notice START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_nviews START WITH 1 INCREMENT BY 1;

SELECT seq_nviews.NEXTVAL FROM DUAL;
SELECT seq_nviews.CURRVAL FROM DUAL;

select * from tbl_notice;


select SEQ_NVIEWS.nextval from tbl_notice;

commit;