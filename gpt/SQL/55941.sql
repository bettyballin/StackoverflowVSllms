-- spool_data.sql\nSET PAGESIZE 0\nSET LINESIZE 32767\nSET LONG 2000000000\nSET LONGCHUNKSIZE 2000000000\nSET FEEDBACK OFF\nSET TRIMSPOOL ON\nSPOOL data_output.txt\nSELECT * FROM your_table;\nSPOOL OFF\nEXIT;