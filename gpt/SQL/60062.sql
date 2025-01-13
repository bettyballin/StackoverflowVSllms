SELECT\n       s.sid,\n       s.serial#,\n       s.username,\n       s.machine,\n       s.program,\n       s.status\n   FROM\n       v$session s,\n       v$locked_object l,\n       dba_objects o\n   WHERE\n       l.object_id = o.object_id\n       AND l.session_id = s.sid;