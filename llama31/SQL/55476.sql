SET ECHO OFF\nSET FEEDBACK OFF\nSET HEADING OFF\nSET LINESIZE 32767\nSET PAGESIZE 0\nSET TERMOUT OFF\nSET TRIM ON\nSET VERIFY OFF\n\nSPOOL /path/to/output/file.txt\n\nSELECT * FROM TEST;\n\nSPOOL OFF\n\nEXIT