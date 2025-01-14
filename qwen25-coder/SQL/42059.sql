SELECT sid, username, osuser, status, seconds_in_wait, blocking_session \n   FROM v$session WHERE last_active_time - SYSDATE/24 < -undo_retention / 86400;