SELECT ID ,EMAIL ,PASSWORD ,NAME ,REGDATE FROM MEMBER;
INSERT INTO MEMBER (ID ,EMAIL ,PASSWORD ,NAME ,REGDATE) VALUES (5, test@test.com, 1234, 'test', sysdate);

DELETE FROM MEMBER WHERE ID=53;
DELETE FROM MEMBER;


SELECT ID ,EMAIL ,PASSWORD ,NAME ,REGDATE AS RegisterDateTime FROM MEMBER;
SELECT ID ,EMAIL ,PASSWORD ,NAME ,REGDATE 
  FROM MEMBER
 WHERE REGDATE BETWEEN '2020-09-01' AND '2020-09-30'
 ORDER BY REGDATE DESC;