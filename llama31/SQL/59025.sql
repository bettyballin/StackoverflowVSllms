SELECT s.sid, s.serial#, p.spid\nFROM v$session s\nJOIN v$process p ON s.paddr = p.addr\nWHERE s.sql_trace = 'ENABLED';