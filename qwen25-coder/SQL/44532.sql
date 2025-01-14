-- Connect to your Oracle database\nCONNECT username/password@database\n\n-- Set server output on and format results\nSET SERVEROUTPUT ON\nSET LINESIZE 3000\nSET PAGESIZE 999\n\n-- Spool the text of the stored procedure to a file\nSPOOL my_stored_procedure.sql\n\nSELECT DBMS_METADATA.GET_DDL('PROCEDURE', 'STORED_PROC_NAME', 'OWNER_SCHEMA') FROM DUAL;\n\n-- Close spool\nSPOOL OFF