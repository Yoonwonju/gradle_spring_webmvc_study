SELECT ID ,EMAIL ,PASSWORD ,NAME ,REGDATE FROM MEMBER;
INSERT INTO MEMBER (ID ,EMAIL ,PASSWORD ,NAME ,REGDATE) VALUES (5, test@test.com, 1234, 'test', sysdate);

DELETE FROM MEMBER WHERE ID=46;
DELETE FROM MEMBER;