SQL> set long 1000000\nSQL> set longchunksize 1000000\nSQL> spool create_table.sql\nSQL> SELECT DBMS_METADATA.get_ddl('TABLE', 'SNP_CLEARINGHOUSE') FROM DUAL;\nSQL> spool off