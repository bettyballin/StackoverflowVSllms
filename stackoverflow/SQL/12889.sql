BEGIN TRANSACTION;\nSELECT DISTINCT url FROM urls WHERE task_assigned is NULL ORDER BY id LIMIT 100 FOR UPDATE;\nUPDATE urls SET task_assigned = NOW() WHERE url IN [list of URLs] COLLATE utf8_bin;\nCOMMIT;