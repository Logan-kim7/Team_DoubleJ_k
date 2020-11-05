create table tbl_user
(
seq	        NUMBER		   PRIMARY KEY,
email	    nVARCHAR2(100) UNIQUE NOT NULL,
pwd	        nVARCHAR2(30)  NOT NULL,
roll	    NUMBER	       DEFAULT 0,
dates	    VARCHAR2(10)   NOT NULL	
);
DROP TABLE TBL_USER;
-- 시퀀스 생성 -------------------------------
CREATE SEQUENCE seq_user
start WITH 1 INCREMENT by 1;
-----------------------------------------------
SELECT * FROM USER_SEQUENCES; -- 전체 시퀀스 조회
-----------------------------------------------
select * from tbl_user;

commit;