SELECT id,\n       client,\n       project,\n       task,\n       REPLACE(REPLACE(ifnull(ts.description,''),'\n','\\n'),'\r','\\r') AS description,\n       time,\n       date\n      INTO OUTFILE '/path/to/file.csv'\n      FIELDS ESCAPED BY '""'\n      TERMINATED BY ',' ENCLOSED BY '"'\n      LINES TERMINATED BY '\n'\n      FROM ....