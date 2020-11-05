--USER1 화면입니다.

CREATE TABLESPACE dripbag
DATAFILE 'C:/bizwork/workspace/dbms/dripbag_tbs/dripbag.dbf'
SIZE 1M AUTOEXTEND ON NEXT 500K;

CREATE USER dripbag IDENTIFIED BY dripbag
DEFAULT TABLESPACE dripbag;


DROP USER dripbag;


GRANT DBA TO dripbag;








