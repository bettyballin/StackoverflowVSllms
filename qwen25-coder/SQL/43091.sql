SELECT SID, BLOCKING_SESSION, EVENT, WAIT_CLASS, STATUS\n   FROM V$SESSION WHERE USERNAME IS NOT NULL AND WAIT_CLASS != 'Idle';