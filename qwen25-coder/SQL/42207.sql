SELECT request_session_id AS SPID, \n          blocking_session_id, status\n   FROM  sys.dm_exec_requests\n   WHERE request_session_id = <your_suspected_session_id>;