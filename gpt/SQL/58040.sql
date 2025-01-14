SET HEADING OFF\n   SET ECHO OFF\n   SET FEEDBACK OFF\n   SET PAGESIZE 0\n   SET LONG 1000000\n\n   SPOOL my_package_spec.sql\n   SELECT DBMS_METADATA.GET_DDL('PACKAGE_SPEC', 'MY_PACKAGE', 'MY_SCHEMA') FROM DUAL;\n   SPOOL OFF\n\n   SPOOL my_package_body.sql\n   SELECT DBMS_METADATA.GET_DDL('PACKAGE_BODY', 'MY_PACKAGE', 'MY_SCHEMA') FROM DUAL;\n   SPOOL OFF