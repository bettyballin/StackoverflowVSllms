SELECT s.username, \n       s.sid, \n       s.serial#, \n       su.tablespace, \n       t.sql_id,\n       t.sql_text\nFROM v$temp_extent_pool tep, \n     v$sort_usage su, \n     v$session s, \n     v$sql t\nWHERE tep.file_id = su.extents_file_id\nAND tep.tempfile# = su.extent_tempfile#\nAND su.session_addr = s.saddr\nAND s.sql_id = t.sql_id;