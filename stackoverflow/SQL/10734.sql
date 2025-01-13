SELECT questionid,\n       LTRIM(MAX(SYS_CONNECT_BY_PATH(elementid,','))\n       KEEP (DENSE_RANK LAST ORDER BY curr),',') AS elements\nFROM   (SELECT questionid,\n               elementid,\n               ROW_NUMBER() OVER (PARTITION BY questionid ORDER BY elementid) AS curr,\n               ROW_NUMBER() OVER (PARTITION BY questionid ORDER BY elementid) -1 AS prev\n        FROM   emp)\nGROUP BY questionid\nCONNECT BY prev = PRIOR curr AND questionid = PRIOR questionid\nSTART WITH curr = 1;