SELECT TRUNC (SYSDATE - ROWNUM) dt\n  FROM DUAL CONNECT BY ROWNUM < 366