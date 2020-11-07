create table tbl_googleList
(
    seq	NUMBER		PRIMARY KEY	,
    dates	VARCHAR2(10)	NOT NULL	,
    title	nVARCHAR2(225)	NOT NULL	,	
    img	nVARCHAR2(225)			
);

create SEQUENCE seq_googleList start WITH 1 INCREMENT by 1;
drop sequence seq_googleList;
commit;