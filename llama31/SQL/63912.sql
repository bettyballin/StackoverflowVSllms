-- Check alert.log\nSELECT * FROM V$DIAG_INFO WHERE name = 'alert.log';\n\n-- Check listener.log\nSELECT * FROM V$DIAG_INFO WHERE name = 'listener.log';\n\n-- Run top command\nSELECT * FROM V$SESSION ORDER BY cpu_usage DESC;\n\n-- Check V$SESSION view\nSELECT * FROM V$SESSION WHERE status = 'ACTIVE' AND last_call_et > 300;