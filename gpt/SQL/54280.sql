SELECT \n    USERNAME,\n    SID,\n    COUNT(*) AS OPEN_CURSORS\nFROM \n    V$OPEN_CURSOR\nGROUP BY \n    USERNAME, SID\nORDER BY \n    OPEN_CURSORS DESC;