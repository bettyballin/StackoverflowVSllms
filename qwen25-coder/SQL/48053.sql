-- Trace a session (replace 'session_id' and 'serial#' with actual values)\nEXEC DBMS_MONITOR.SESSION_TRACE_ENABLE(session_id => 12345, serial_num => 6789);\n-- After executing the operation on front end\nEXEC DBMS_MONITOR.SESSION_TRACE_DISABLE(session_id => 12345); \n\n-- Check trace files as before