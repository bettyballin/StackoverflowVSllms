SELECT * FROM V$TRANSACTION WHERE XIDUSN = (SELECT XIDUSN FROM V$MESSAGE_XIDS WHERE SESSION_ID = SYS_CONTEXT('USERENV', 'SESSIONID'));