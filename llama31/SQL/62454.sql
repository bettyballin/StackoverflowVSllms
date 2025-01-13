SELECT \n  (SELECT COUNT(*) FROM V$SESSION) AS CURRENT_SESSIONS,\n  (SELECT VALUE FROM V$PARAMETER WHERE NAME = 'sessions') AS MAX_SESSIONS\nFROM \n  DUAL;