ALTER SESSION SET EVENTS '10053 trace name context forever, level 1';\nEXEC :cursor := SYS.SQL_ID('sql_id'); -- Get a cursor number for the SQL ID\n-- Run your query here\nALTER SESSION SET EVENTS '10053 trace name context off';