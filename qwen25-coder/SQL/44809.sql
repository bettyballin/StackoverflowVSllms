SELECT event, COUNT(*) AS wait_count\nFROM v$session_wait\nWHERE event LIKE 'enq: TX%'\nGROUP BY event;