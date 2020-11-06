-- ?ó¨Í∏∞Îäî dripbag ?ïô?õê ?Ñ§Î∞îÎã§

CREATE TABLE tbl_googleComent (
    seq	NUMBER		PRIMARY KEY ,
    seqc NUMBER	UNIQUE NOT NULL 	,
    writer	nVARCHAR2(100)	NOT NULL ,	
    dates	VARCHAR2(10)	NOT NULL ,	
    times	VARCHAR2(10)	NOT NULL ,	
    title	nVARCHAR2(4)	NOT NULL ,	
    cont	nVARCHAR2(20)		,
    likes	NUMBER		,
    views	NUMBER		
);

DROP TABLE tbl_googleComent;

CREATE SEQUENCE SEQ_GC
START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE SEQ_GCC
START WITH 1 INCREMENT BY 1;

DROP SEQUENCE SEQ_GC;
DROP SEQUENCE SEQ_GCC;

SELECT * FROM tbl_googleComent;


commit;







