create table tbl_user
(
d_seq	    NUMBER		   PRIMARY KEY,
d_email	    nVARCHAR2(100) UNIQUE NOT NULL,
d_password	nVARCHAR2(30)  NOT NULL,
d_roll	    NUMBER	       DEFAULT 1,
d_date	    VARCHAR2(10)   NOT NULL	
);
DROP TABLE TBL_USER;
-- ������ ���� -------------------------------
CREATE SEQUENCE seq_user
start WITH 1 INCREMENT by 1;
-----------------------------------------------
SELECT * FROM USER_SEQUENCES; -- ��ü ������ ��ȸ
-----------------------------------------------
select * from tbl_user;
