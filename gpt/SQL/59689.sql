SELECT TRUNC(SYSDATE, 'DD') + (TRUNC(TO_NUMBER(TO_CHAR(SYSDATE, 'SSSSS')) / 60) * INTERVAL '1' MINUTE) + MOD(TO_NUMBER(TO_CHAR(SYSDATE, 'SSSSS')), 60) * INTERVAL '1' SECOND\nFROM dual;