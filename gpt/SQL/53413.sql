SET LONG 10000\nSET PAGESIZE 0\nSET LINESIZE 200\nSELECT DBMS_METADATA.GET_DDL('TABLE', 'SNP_CLEARINGHOUSE') FROM DUAL;