SELECT u.userid, u.name\nFROM users u\nJOIN status_log sl ON u.userid = sl.userid\nWHERE sl.logcreated <= '2008-01-15'  -- or any other date you want to query\nAND sl.status = 'a'\nAND NOT EXISTS (\n  SELECT 1\n  FROM status_log sl2\n  WHERE sl2.userid = u.userid\n  AND sl2.logcreated > sl.logcreated\n  AND sl2.logcreated <= '2008-01-15'\n  AND sl2.status = 's'\n);