alertlog=$(sqlplus -S \/ as sysdba 2> /dev/null <<EOF\nSET NEWPAGE 0\nSET SPACE 0\nSET LINESIZE 80\nSET PAGESIZE 0\nSET ECHO OFF\nSET FEEDBACK OFF\nSET VERIFY OFF\nSET HEADING OFF\nSELECT value \nFROM   v\$parameter \nWHERE  name = 'background_dump_dest';\nEOF\n)